package pl.basicAction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckSelector {

    public boolean checker(String optionText, WebElement element){
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options){
            if (option.getText().equals(optionText))
                return true;
        }
        return false;
    }

}


