package pl.basicAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WaitTest {

    @Test
    public void setWait() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();


        Thread.sleep(1000);
        FluentWait<WebDriver> wait = new FluentWait<>(driver);

        wait.ignoring(NoSuchFieldError.class);
        wait.withTimeout(Duration.ofSeconds(11));

        driver.findElement(By.id("clickOnMe")).click();


        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.tagName("p")
                )
        );
        WebElement para = driver.findElement(By.cssSelector("p"));

        Assert.assertEquals(para.isDisplayed(), true);
        Assert.assertTrue(para.isDisplayed());
        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertFalse(para.getText().startsWith("Pojawiłem"));
        Assert.assertEquals(para.getText(), "Dopiero się pojawiłem!");
        driver.quit();
    }
}