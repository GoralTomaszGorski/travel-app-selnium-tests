package pl.seleniumdemo.testsPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;
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

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstname("Tomek");
        signUpPage.setLastName(lastName);
        signUpPage.setPhone("603254447");
        signUpPage.setEmail(email);
        signUpPage.setPassword("123qwerty");
        signUpPage.confirmPassword("123qwerty");
        signUpPage.signUpClick();
        Thread.sleep(1000);
        
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText() ,"Hi, Tomek Górski");

    }
}