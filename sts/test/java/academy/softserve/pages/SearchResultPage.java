package academy.softserve.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

    WebDriver driver;
    By searchResults = By.cssSelector(".r>a");
    By allResults = By.xpath(".//*[@id='hdtb-msb']/div[1]/div[1]");
    By imagesResults = By.linkText("Картинки");

    // By newsResults = By.();
    // By mapsResults = By.("");
    // By more = By.("");
    // By settings = By("");
    // By tools = By.("");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    // get all results

    public List<WebElement> getAllResults() {
        List<WebElement> elements = driver.findElements(searchResults);
        return elements;

    }

    // get images results

    public GoogleImagesSearchResultPage getImagesResults() {
        driver.findElement(imagesResults).click();
        return new GoogleImagesSearchResultPage(driver);

    }

}
