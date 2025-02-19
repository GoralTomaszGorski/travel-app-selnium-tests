package pl.seleniumdemo.testsPatterns;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultPage;
import pl.seleniumdemo.tests.BaseTest;

import java.util.List;

public class HotelSearchWithPatternTest extends BaseTest {

    @Test
    public void hotelSearchWithPattern() {

        ExtentTest test = extentReports.createTest("Search Hotel Test");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage
                .setCity("Dubai")
                .setDates("27/04/2025", "29/04/2025")
                .setTravellers(2,2)
                .performSearch();
        test.log(Status.PASS, "Settings city done");
        test.log(Status.PASS, "Settings dates done");
        test.log(Status.PASS, "Settings travellers done");

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

        test.log(Status.PASS, "Assertion passed");

    }
}
