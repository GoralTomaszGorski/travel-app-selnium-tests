package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelSearchPage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchHotelSpan;

    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    private WebElement searchHotelInput;

    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    private WebElement travellersInput;

    @FindBy(id ="adultInput")
    public WebElement adultInput;

    @FindBy(id ="childInput")
    public WebElement childInput;

    @FindBy(id = "adultPlusBtn")
    public WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='li_myaccount']")
    private List<WebElement> myAccountLink;

    @FindBy(linkText = "Sign Up")
    private List<WebElement> signUpLink;

    private WebDriver driver;

    public HotelSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setCity(String city){
        searchHotelSpan.click();
        searchHotelInput.sendKeys(city);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", city);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void setDates(String checkIn, String checkOut){
        checkInInput.sendKeys(checkIn);
        checkOutInput.sendKeys(checkOut);
    }

    public void  setTravellers(int adultsAdd, int childAdd){
        travellersInput.click();
        adultInput.clear();
        adultInput.sendKeys("0");
        childInput.clear();
        childInput.sendKeys("0");

        for (int i = 0; i < adultsAdd; i++) {
            adultPlusBtn.click();
        }
        for (int i = 0; i < childAdd; i++) {
            childPlusBtn.click();
        }
    }

    public void performSearch(){
        searchButton.click();
    }

    public void openSignUpForm(){
        myAccountLink.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        signUpLink.get(1).click();
    }

}


