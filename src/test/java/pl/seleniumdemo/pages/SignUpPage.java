package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    @FindBy (name = "firstname")
    private WebElement firstNameInput;

    @FindBy (name = "lastname")
    private WebElement lastNameInput;

    @FindBy (name = "phone")
    private WebElement phoneInput;

    @FindBy (name = "email")
    private WebElement emailInput;

    @FindBy (name = "password")
    private WebElement passwordInput;

    @FindBy (name = "confirmpassword")
    private WebElement confirmPasswordInput;

    @FindBy (className = "signupbtn")
    private WebElement signUpBtn;

    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setFirstname(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void setEmail(String email){
        emailInput.sendKeys(email);
    }

    public void setPhone(String phone){
        phoneInput.sendKeys(phone);
    }

    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void confirmPassword(String confirmPassword){
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void signUpClick(){
        signUpBtn.click();
    }
}
