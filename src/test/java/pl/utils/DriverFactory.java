package pl.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver getDriver(String name){
        if (name.equals("google")){
            return new FirefoxDriver();


        } else {
            WebDriverManager.chromedriver().config();
            return new ChromeDriver();
        }
    }

}
