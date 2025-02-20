package pl.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.AbstractReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.BeforeSuite;
import pl.utils.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentSparkReporter sparkReporter;
    protected static ExtentReports extentReports;


    @BeforeSuite
    public void beforeSuite() {
        sparkReporter = new ExtentSparkReporter("src/test/resources/report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }
    //https://www.youtube.com/watch?v=xqzJXFNpGIo

    @BeforeMethod
    public void setup() throws IOException {
        sparkReporter = new ExtentSparkReporter("src/test/resources/report.html");
        extentReports = new ExtentReports();
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("MyReport");
        extentReports.attachReporter(sparkReporter);
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();    }
}
