package pl.basicAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumDemoPageTest {

    private final SeleniumChromeTest seleniumChromeTest;

    public SeleniumDemoPageTest(SeleniumChromeTest seleniumChromeTest) {
        this.seleniumChromeTest = seleniumChromeTest;
    }

    @Test
    public void openSeleniumDemoPage2() {
        WebDriverManager.chromedriver().setup();
        String baseUrl = "http://seleniumdemo.com/";

        WebDriver driver = seleniumChromeTest.getDriver(seleniumChromeTest.getChromeOptions(), baseUrl);

        driver.findElement(
                By.xpath("//span[text()='Shop']")).click();
        WebElement seleniumProduct = driver.findElement(
                By.xpath("//h2[text()='Java Selenium WebDriver']"));
        Assert.assertTrue(seleniumProduct.isDisplayed());
    }
}
