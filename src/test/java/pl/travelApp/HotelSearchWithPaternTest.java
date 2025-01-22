package pl.travelApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.pages.tests.HotelSearchPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class HotelSearchWithPaternTest extends BaseTest{

    @Test
    public void hotelSearch() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        hotelSearchPage.serDates("27/04/2025", "29/04/2025");
        hotelSearchPage.setTravellers();
        hotelSearchPage.performSearch();

        List<String> hotelsName = driver.findElements(
                        By.xpath("//h4[contains(@class, 'list_title')]//b"))
                .stream()
                .map(element ->
                        element.getDomProperty("textContent"))
                .collect(Collectors.toList());
        System.out.println(hotelsName.size());
        hotelsName.forEach(el -> System.out.println(el));

        assertEquals("Jumeirah Beach Hotel",
                hotelsName.get(0));
        assertEquals("Oasis Beach Tower",
                hotelsName.get(1));
        assertEquals("Rose Rayhaan Rotana",
                hotelsName.get(2));
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("Hyatt Regency Perth", hotelsName.get(3));

    }
}
