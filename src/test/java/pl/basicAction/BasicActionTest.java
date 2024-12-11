package pl.basicAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionTest {

    @Test
    static void performAction(){
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement basicLink = driver.findElement(
                By.linkText("Podstawowa strona testowa")
        );
        basicLink.click();
        driver.findElement(By.id("clickOnMe")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.name("fname")).sendKeys("Tomek");

        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.clear();
        userNameInput.sendKeys("Admin");
        System.out.println(userNameInput.getAttribute("value"));

        userNameInput.sendKeys(Keys.ENTER);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='female']")).click();

        WebElement selectCar = driver.findElement(
                By.cssSelector("select")
        );
        Select cars = new Select(selectCar);
        cars.selectByVisibleText("Saab");

        WebElement selectCar2 = driver.findElement(By.cssSelector("select"));
        Select cars2 = new Select(selectCar2);
        cars.selectByValue("volvo");

        List<WebElement> carList = cars2.getOptions();
        for (WebElement options : carList) {
            System.out.println(options.getText());
        }

        CheckSelector checkSelector = new CheckSelector();
        System.out.println(checkSelector.checker("audi", selectCar));
        System.out.println(checkSelector.checker("jeep", selectCar));

        WebElement paragraph = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By text: " + paragraph.getText());
        System.out.println("By value: " + paragraph.getAttribute("value"));
        System.out.println("By content: " + paragraph.getAttribute("textContent"));
    }
}