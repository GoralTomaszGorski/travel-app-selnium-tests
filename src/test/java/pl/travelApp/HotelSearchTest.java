package pl.travelApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class HotelSearchTest {

    @Test
    public void hotelSearch() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
                .filter(element -> element.isDisplayed())
                .findFirst().ifPresent(element -> element.click());
        Thread.sleep(5000);
        driver.quit();

    }
}
