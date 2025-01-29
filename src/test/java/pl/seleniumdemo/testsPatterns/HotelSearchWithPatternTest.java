package pl.seleniumdemo.testsPatterns;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultPage;
import pl.seleniumdemo.tests.BaseTest;

import java.util.List;

public class HotelSearchWithPatternTest extends BaseTest {

    @Test
    public void hotelSearchWithPattern() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        hotelSearchPage.setDates("27/04/2025", "29/04/2025");
        hotelSearchPage.setTravellers(2,2);
        hotelSearchPage.performSearch();

        ResultPage resultPage = new ResultPage(driver);
        List<String> hotelNames = resultPage.getHotelsName();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("Jumeirah Beach Hotel",
                hotelNames.get(0));
        softAssert.assertEquals("Oasis Beach Tower",
                hotelNames.get(1));
        softAssert.assertEquals("Rose Rayhaan Rotana",
                hotelNames.get(2));
        softAssert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));

    }


}
