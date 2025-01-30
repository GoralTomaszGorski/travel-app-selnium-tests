package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    @FindBy (name = "firstname")
    private WebElement firstnameInput;
    @FindBy (name = "lastname")
    private WebElement lastnameInput;
    @FindBy (name = "phone")
    private WebElement phoneInput;
    @FindBy (name = "email")
    private WebElement emailInput;
    @FindBy (name = "password")
    private WebElement passwordInput;  
    @FindBy (name = "confirmpassword")
    private WebElement confirmpasswordInput;
    @FindBy (name = "signupbtn")
    private WebElement signupbtnBtn;
    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        
    }
    public void setFirstname(String firstName){
        firstnameInput.sendKeys(firstName);
    }
    public void setLastName(String lastName){
        lastnameInput.sendKeys(lastName);
    }
    public void setPhone(String phone){
        phoneInput.sendKeys(phone);
    }
    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void confirmPassword(String confirmpassword){
        confirmpasswordInput.sendKeys(confirmpassword);
    }
    public void signUp(){
    }
}
