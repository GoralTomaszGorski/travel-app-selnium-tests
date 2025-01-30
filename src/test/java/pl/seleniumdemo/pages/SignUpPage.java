package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {



    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        
    }



}
