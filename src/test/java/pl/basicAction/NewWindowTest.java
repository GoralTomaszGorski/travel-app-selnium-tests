package pl.basicAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewWindowTest {

    @Test
    public void testNewWindow(){
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        String startPage = driver.getWindowHandle();

        driver.findElement(
                By.linkText("Strona z iframe"))
                .click();
        String iframePage = driver.getWindowHandle();

        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.id("fname")).sendKeys("Tomek");
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    @Test
    public void testGooglePage() {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://google.com");
        WebElement ac = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]"));
        ac.click();
    }
}
