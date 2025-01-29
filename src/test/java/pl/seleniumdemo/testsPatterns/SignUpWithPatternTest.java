package pl.seleniumdemo.testsPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.tests.BaseTest;

public class SignUpWithPatternTest extends BaseTest {

    @Test
    public void signUp() throws InterruptedException {

        String lastName = "Górski";
        int randomNumber = (int) (Math.random()*1000);
        String email = "emailtomka" + randomNumber + "@telen.pl";

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();
        Thread.sleep(1000);

        driver.findElement(By.name("firstname")).sendKeys("Tomek");
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys("603215114");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("confirmpassword")).sendKeys("123456");

        Thread.sleep(1000);
        driver.findElement(By.className("signupbtn")).click();

        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));

        Assert.assertTrue(heading.getText().contains(lastName));
        Assert.assertEquals(heading.getText(), "Hi, Tomek Górski");

    }
}
