package pl.seleniumdemo.testsDataProvider.testsPatterns;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultPage;
import pl.seleniumdemo.tests.BaseTest;

public class HotelSearchWithoutNameWithDataProviderTest extends BaseTest {

    @Test
    public void HotelSearchWithoutNameTest() throws InterruptedException {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setDates("27/04/2025", "30/04/2025");
        hotelSearchPage.setTravellers(0, 2);
        hotelSearchPage.performSearch();
        Thread.sleep(1000);

        ResultPage resultPage = new ResultPage(driver);
        Assert.assertTrue(resultPage.resultHeading.isDisplayed());

        Assert.assertEquals(resultPage.getHeadingText(), "No Results Found");
    }
}

