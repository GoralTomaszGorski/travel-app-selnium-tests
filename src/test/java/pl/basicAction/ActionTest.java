package pl.basicAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTest {

    @Test
    public void actionsTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        WebElement button =  driver.findElement(By.id("bottom"));

        Actions actions = new Actions(driver);

        actions.moveToElement(button).perform();

        actions.contextClick(button).perform();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        actions.doubleClick(button).perform();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
}
