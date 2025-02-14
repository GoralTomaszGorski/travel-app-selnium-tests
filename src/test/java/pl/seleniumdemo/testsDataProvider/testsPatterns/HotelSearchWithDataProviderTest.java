package pl.seleniumdemo.testsDataProvider.testsPatterns;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultPage;
import pl.seleniumdemo.tests.BaseTest;
import pl.utils.ExcelReader;

import java.io.IOException;
import java.util.List;

public class HotelSearchWithDataProviderTest extends BaseTest {

    @Test(dataProvider = "data")
    public void hotelSearch(String city, String hotel) {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage
                .setCity(city)
                .setDates("27/04/2025", "29/04/2025")
                .setTravellers(2, 2)
                .performSearch();

        ResultPage resultPage = new ResultPage(driver);
        List<String> hotelNames = resultPage.getHotelsName();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(hotel,
                hotelNames.get(0));

    }

    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("dataTest.xlsx");
    }
}
