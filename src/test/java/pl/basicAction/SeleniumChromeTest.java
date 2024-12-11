package pl.basicAction;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumChromeTest {

    public WebDriver getDriver(ChromeOptions options, String baseUrl) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }

    public ChromeOptions getChromeOptions() {
        String path = "/home/tomaszgorski/Dokumenty/chromedriver-linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return options;
    }
}