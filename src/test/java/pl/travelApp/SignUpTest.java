package pl.travelApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class SignUpTest {

    @Test
    public void signUp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        driver.findElements(By.xpath("//*[@id='li_myaccount']"))
                .stream().filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
        Thread.sleep(1000);

        driver.findElement(By.linkText("Sign Up")).click();

        String lastName = "Górski";
        driver.findElement(By.name("firstname")).sendKeys("Tomek");
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys("603215114");
        driver.findElement(By.name("email")).sendKeys("tomek53@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("confirmpassword")).sendKeys("123456");

        Thread.sleep(1000);
        driver.findElement(By.className("signupbtn")).click();

        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));

        Assert.assertTrue(heading.getText().contains(lastName));
        Assert.assertEquals(heading.getText(), "Hi, Tomek Górski");

        Thread.sleep(5000);
        driver.quit();

    }
}
