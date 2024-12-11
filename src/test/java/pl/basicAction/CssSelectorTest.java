package pl.basicAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
public class CssSelectorTest {
    @Test
    public void findElementByCss() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssInput = By.cssSelector("#fname");
        driver.findElement(cssInput);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("coś wprowadzam w input");
        List<WebElement> inputsByCss = driver.findElements(cssTag);
        System.out.println(inputsByCss);

        By all = By.cssSelector("*");
        List<WebElement> allElements = driver.findElements(all);

        By ulInsideDiv = By.cssSelector("div ul");
        By trInTable = By.cssSelector("table  tr");
        By trInBody = By.cssSelector("tbody  tr");

        driver.findElements(ulInsideDiv);
        driver.findElements(trInTable);
        driver.findElements(trInBody);

        By firstChildUlInDiv = By.cssSelector("div > ul");
        By firstChildTrInTbody = By.cssSelector("tbody > tr");

        driver.findElements(firstChildTrInTbody);
        driver.findElements(firstChildUlInDiv);

        By attrTag = By.cssSelector("input[name ='fname']");
        By attrConteins = By.cssSelector("[name*='user']");
        By attrStarts = By.cssSelector("[name^='f']");
        By attrEnds = By.cssSelector("[name$='er']");

        driver.findElement(attrTag);
        driver.findElement(attrConteins);
        driver.findElement(attrStarts);
        driver.findElement(attrEnds);
    }
}