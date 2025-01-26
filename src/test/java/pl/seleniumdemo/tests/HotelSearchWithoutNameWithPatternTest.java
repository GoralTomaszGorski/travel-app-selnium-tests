package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultPage;

import java.util.List;
import java.util.stream.Collectors;

public class HotelSearchWithoutNameWithPatternTest extends BaseTest {

    @Test
    public void HotelSearchWithoutNameTest(){

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setDates("27/04/2025", "30/04/2025");
        hotelSearchPage.setTravellers(0,2);
        hotelSearchPage.performSearch();

        ResultPage resultPage = new ResultPage(driver);
        Assert.assertTrue(resultPage.resultHeading.isDisplayed());

        Assert.assertEquals(resultPage.getHeadingText(), "No Results Found");


    }
}
