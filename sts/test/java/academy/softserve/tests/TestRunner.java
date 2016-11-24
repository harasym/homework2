package academy.softserve.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import academy.softserve.utils.ScreenshotMaker;

public class TestRunner {

    public WebDriver driver;

    @BeforeMethod
    public void setUpDriver() {

        final String driverPath = "srs\\main\\";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        ScreenshotMaker.takeIt(driver);
        driver.quit();
    }
}
