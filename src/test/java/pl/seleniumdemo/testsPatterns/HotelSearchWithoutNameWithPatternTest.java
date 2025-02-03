package pl.seleniumdemo.testsPatterns;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultPage;
import pl.seleniumdemo.tests.BaseTest;

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

