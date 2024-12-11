package pl.basicAction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExistTest {

    WebDriver driver;

    @Test
    public void findElementByCss() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println("we manually check that element exist by try catch");
        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        System.out.println("we manually check that element exist by list size");
        System.out.println(elementExistSecond(By.tagName("p")));
        System.out.println(elementExistSecond(By.id("topSecret")));

        System.out.println("we check that element exist by isDisplayed method");
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());

        System.out.println("we check that element is enabled by isEnabled method");
        System.out.println(driver.findElement(By.tagName("p")).isEnabled());
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());

        System.out.println("we check that element is isSelected example checkbox");
        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        System.out.println(checkbox.isSelected());

        //sprwdzenie rzomiaru zdjecia mozna inne atrubuty sprawdzic
        WebElement image = driver.findElement(By.tagName("img"));
        System.out.println(image.getAttribute("naturalHeight"));
    }

    public boolean elementExist(By locator){
        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean elementExistSecond(By locator){
        return driver.findElements(locator).size() > 0;
    }
}
