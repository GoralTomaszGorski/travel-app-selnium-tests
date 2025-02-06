package pl.seleniumdemo.pages;

import org.checkerframework.checker.units.qual.radians;
import org.checkerframework.checker.units.qual.t;
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

    @FindBy(partialLinkText = "Sign Up")
    WebElement signUpLink;

//    go-text-right
//            driver.findElement(By.linkText("Sign Up")).click();

    private WebDriver driver;

    public HotelSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HotelSearchPage setCity(String city){
        System.out.println("Setting city" + city);
        searchHotelSpan.click();
        searchHotelInput.sendKeys(city);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", city);
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public HotelSearchPage setDates(String checkIn, String checkOut){
        System.out.println("setting dates checkIn:" + checkIn + " or checkOut: " + checkOut);
        checkInInput.sendKeys(checkIn);
        checkOutInput.sendKeys(checkOut);
        return this;
    }

    public HotelSearchPage  setTravellers(int adultsAdd, int childAdd){
        System.out.println("setting travellers adultsAdd: " + adultsAdd + " or childAdd: " + childAdd);
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
        return this;
    }

    public HotelSearchPage performSearch(){
        System.out.println("performing search ");
        searchButton.click();
        System.out.println("performed search ");
        return this;
    }

    public HotelSearchPage openSignUpForm(){
        myAccountLink.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        signUpLink.click();
        return this;
    }

}


