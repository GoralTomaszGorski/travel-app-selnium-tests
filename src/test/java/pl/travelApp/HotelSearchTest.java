package pl.travelApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
//*[@id="select2-drop"]/div/input
        Thread.sleep(5000);
        driver.quit();

    }
}
