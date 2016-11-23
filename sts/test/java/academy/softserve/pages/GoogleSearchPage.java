package academy.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearchPage {

    WebDriver driver;
    By searchField = By.id("lst-ib");
    By searchButton = By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[1]");
    By randomSearchButton = By.xpath(".//*[@id='tsf']//input[2]");
    By googleLogo = By.xpath(".//*[@id='hplogo']");

    // By searchImages = By.id(id);
    // By gmail = By.className(className);

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogo() {
        return driver.findElement(googleLogo);
    }

    public WebElement gerSearchButton() {
        return driver.findElement(searchButton);
    }

    // Input search request in searchfield

    public void setSerachRequest(String searchRequest) {
        driver.findElement(searchField).sendKeys(searchRequest);

    }

    // Click on search button

    public void clickSearch() {
        Actions builder = new Actions(driver);
        builder.moveToElement(gerSearchButton()).doubleClick().build().perform();


    }

    // Click on random search button

    public void clickRandomeSearch() {
        driver.findElement(randomSearchButton).click();

    }

    // get all search results

    public SearchResultPage googleSearch(String searchRequest) throws InterruptedException {
        this.setSerachRequest(searchRequest);
        getLogo().click();
        Thread.sleep(1500);
        clickSearch();
        return new SearchResultPage(driver);

    }

    // get one random search results

    // public SearchResultPage googleRandomSearch(String searchRequest) {
    // this.setSerachRequest(searchRequest);
    // this.clickRandomeSearch();
    // return new Ran(driver);

    // }

}
