package academy.softserve.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import academy.softserve.pages.GoogleSearchPage;
import academy.softserve.pages.SearchResultPage;

public class GoogleSearchTest {

    WebDriver driver;

    GoogleSearchPage searchPage;

    SearchResultPage searchResultpage;

    @BeforeTest

    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "srs\\main\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
        // driver.manage().window().fullscreen();
        driver.get("http://www.google.com.ua/preferences");
        driver.findElement(By.xpath(".//*[@id='instant-radio']/div[3]/span")).click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        driver.findElement(By.xpath(".//*[@id='form-buttons']/div[1]")).click();
        driver.get("http://google.com.ua");

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @Test(priority = 0)

    public void test_Google_Page() {
        searchPage = new GoogleSearchPage(driver);
        Assert.assertTrue(searchPage.getLogo().isDisplayed());
    }

    @Test

    public void test_search_funny_images() throws InterruptedException {
        searchPage = new GoogleSearchPage(driver);
        SearchResultPage searchResultpage = searchPage.googleSearch("funny picture");
       ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        // searchResultpage.getImagesResults();
        Thread.sleep(1000);
        Assert.assertTrue(searchResultpage.getAllResults().get(0).getText().toLowerCase().contains("funny picture"));

    }

}
