package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public HotelSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HotelSearchPage setCity(String city){
        logger.info("Setting city: " + city);
        searchHotelSpan.click();
        searchHotelInput.sendKeys(city);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", city);
        driver.findElement(By.xpath(xpath)).click();
        logger.info("Setting city done city is: " + city);
        return this;
    }

    public HotelSearchPage setDates(String checkIn, String checkOut){
        logger.info("setting dates checkIn:" + checkIn + " or checkOut: " + checkOut);
        checkInInput.sendKeys(checkIn);
        checkOutInput.sendKeys(checkOut);
        return this;
    }

    public HotelSearchPage  setTravellers(int adultsAdd, int childAdd){
        logger.info("setting travellers adultsAdd: " + adultsAdd + " or childAdd: " + childAdd);
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
        logger.info("performing search ");
        searchButton.click();
        logger.info("performed search ");
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


