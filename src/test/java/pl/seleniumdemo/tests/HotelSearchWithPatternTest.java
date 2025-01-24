package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class HotelSearchWithPatternTest extends BaseTest{

    @Test
    public void hotelSearch() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        hotelSearchPage.serDates("27/04/2025", "29/04/2025");
        hotelSearchPage.setTravellers();
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
