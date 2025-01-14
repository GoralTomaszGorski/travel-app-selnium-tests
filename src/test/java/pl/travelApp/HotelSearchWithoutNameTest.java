package pl.travelApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class HotelSearchWithoutNameTest extends BaseTest {

    @Test
    public void hotelSearch() throws InterruptedException {

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
        WebElement noResultHeading = driver.findElement(By.xpath("//div[@class='itemscontainer']//h2"));
        System.out.println(noResultHeading.getText());
        Assert.assertTrue(noResultHeading.isDisplayed());
        Assert.assertEquals("No Results Found", noResultHeading.getText());

    }
}
