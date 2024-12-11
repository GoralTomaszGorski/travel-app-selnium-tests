package pl.basicAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findElement(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);

        By firstName = By.name("fname");
        WebElement firstNameInput = driver.findElement(firstName);
        //to samo co wyżej w jednej linijce
        WebElement firstNameInput2 = driver.findElement(By.name("fname"));

        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);

        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy input");

        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println("lista ma wielkość");
        System.out.println(inputs.size());

        By linkText = By.linkText("Visit W3Schools.com!");
        WebElement schoolLink = driver.findElement(linkText);

        By partialLinkText = By.partialLinkText("Visit W3Scho");
        WebElement schoolPartaialLink = driver.findElement(partialLinkText);
    }
}
