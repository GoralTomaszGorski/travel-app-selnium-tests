package pl.basicAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathSelectorTest {

    public static void printer(WebElement webElement){
        System.out.println(webElement.hashCode());
    }

    public static void listPrinter(List<WebElement> webElementsList) {
        for (int i = 0; i < webElementsList.size(); i++) {
            System.out.print(i+1+". ");
            printer(webElementsList.get(i));
        }
    }

    @Test
    public void findElementByXpath(){
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By fullPath = By.xpath("/html/body/div/ul");
        WebElement fullPathSelector = driver.findElement(fullPath);
        printer(fullPathSelector);

        By shortPath = By.xpath("//ul");
        WebElement shortPathSelector = driver.findElement(shortPath);
        printer(shortPathSelector);

        By buttonId = By.xpath("//*[@id=\"clickOnMe\"]");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        printer(clickOnMeButton);

        By buttonIdFullName = By.xpath("/html/body/button[@id='clickOnMe']");
        WebElement butElement = driver.findElement(buttonIdFullName);
        printer(butElement);

        By fnameInput = By.xpath("//*[@id=\"fname\"]");
        WebElement fnameInputElement = driver.findElement(fnameInput);
        printer(fnameInputElement);

        By inputsLocator = By.xpath("//input");
        WebElement inputElement = driver.findElement(inputsLocator);
        printer(inputElement);

        driver.findElement(inputsLocator).sendKeys("coś wprowadzam w input nr 1");
        List<WebElement> inputsList = driver.findElements(inputsLocator);
        System.out.println("liczba inputów w liście: " + inputsList.size());
        listPrinter(inputsList);

        System.out.println();
        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolLink = driver.findElement(linkText);
        printer(schoolLink);

        By linkText2 = By.xpath("//a[contains(text(), 'Visit')] ");
        WebElement schoolLink2 = driver.findElement(linkText2);
        printer(schoolLink2);

        By allXpath = By.xpath("//*");
        printer(driver.findElement(allXpath));

        By secondElement = By.xpath("(//input)[2]");
        printer(driver.findElement(secondElement));

        By lastElement = By.xpath("(//input)[last()]");
        printer(driver.findElement(lastElement));

        By elementsWithAttribute = By.xpath("(//*[@name])");
        driver.findElements(elementsWithAttribute);

        driver.findElements(elementsWithAttribute);

        By elementWithAttributeName = By.xpath("//*[@name='fname']");
        driver.findElement(elementWithAttributeName);

        By idButton = By.xpath("//button[@id='clickOnMe']");
        WebElement buttonWebElementById = driver.findElement(idButton);
        printer(buttonWebElementById);

        By differentThemIdButton = By.xpath("//button[@id!='clickOnMe']");
        WebElement buttonWebElementByIdDifferent = driver.findElement(differentThemIdButton);
        printer(buttonWebElementByIdDifferent);

        By xpathContainsBy = By.xpath("//*[contains(@name, 'ame')]");
        List<WebElement> containsNameList = driver.findElements(xpathContainsBy);
        listPrinter(containsNameList);

        By xpathStartsBy = By.xpath("//*[starts-with(@name, 'user')]");
        WebElement startsWith = driver.findElement(xpathStartsBy);
        printer(startsWith);
        
        By childUlBy = By.xpath("//*[starts-with(@name, 'user')]");
        By descendantUlBy = By.xpath("//div/descendant::ul");
        By descendantAllBy = By.xpath("//div/descendant::*");
        By anescorBy = By.xpath("//div/ancestor::*");


        WebElement childElement = driver.findElement(childUlBy);
        List<WebElement> descendantUlElements = driver.findElements(descendantUlBy);
        List<WebElement> descendantAllElements = driver.findElements(descendantAllBy);
        List<WebElement> ancestorElements = driver.findElements(anescorBy);
        List<WebElement> descendantElements = driver.findElements(descendantUlBy);

        System.out.println(childElement.hashCode());
        listPrinter(descendantUlElements);
        listPrinter(descendantAllElements);
        listPrinter(ancestorElements);
        listPrinter(descendantElements);


        By img = By.xpath("//img");
        By nextByImg = By.xpath("//img/following::*");
        By imgSibling = By.xpath("//img/following-sibling::*");
        By beforeImg = By.xpath("//img/preceding-sibling::*");

        driver.findElement(img);
        driver.findElement(nextByImg);
        driver.findElement(imgSibling);
        driver.findElement(beforeImg);



        By divAndLinkBy = By.xpath("//input | //a");
        By linkAndDivBy = By.xpath("//a | //div");
        By inputAndIdBy = By.xpath("//input[@name='fname' and @id='fname']");
        By inputOrIdBy = By.xpath("//input[@name='blabla' or @id='fname']");

        List<WebElement> divAndLinkByList = driver.findElements(divAndLinkBy);
        List<WebElement> linkAndDivByList = driver.findElements(linkAndDivBy);
        List<WebElement> inputAndIdByList = driver.findElements(inputAndIdBy);
        List<WebElement> inputOrIdByList = driver.findElements(inputOrIdBy);

        listPrinter(divAndLinkByList);
        listPrinter(linkAndDivByList);
        listPrinter(inputAndIdByList);
        listPrinter(inputOrIdByList);
    }
}
