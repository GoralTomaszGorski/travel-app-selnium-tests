package pl.seleniumdemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.seleniumdemo.tests.BaseTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends BaseTest {

    @FindBy(xpath="//h4[contains(@class, 'list_title')]//b")
    private List<WebElement> hotelList;

    public List<String> getHotelsName(){
        return hotelList.stream()
                .map(element -> element.getDomAttribute("textContent"))
                .collect(Collectors.toList());
    }



}
