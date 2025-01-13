package pl.travelApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class HotelSearchTest extends BaseTest{



    @Test
    public void hotelSearch() throws InterruptedException {
        driver.findElement(By.xpath(
                "//span[text()='Search by Hotel or City Name']"
        )).click();
        driver.findElement(By.xpath(
                "//*[@id='select2-drop']/div/input"
        )).sendKeys("Dubai");
        driver.findElement(By.xpath(
                "//span[@class='select2-match' and text()='Dubai']"
        )).click();
        WebElement checkin = driver.findElement(By.name("checkin"));
        checkin.sendKeys("17/01/2025");
        checkin.click();
        WebElement checkout = driver.findElement(By.name("checkout"));
        checkout.sendKeys("25/01/2025");

        driver.findElements(By.xpath(
                        "//td[@class='day ' and text()='26']"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);

        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("adultPlusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();
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
