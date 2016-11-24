package academy.softserve.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleImagesSearchResultPage extends GoogleMenuPage{
    
    WebDriver driver;

    By searchResults = By.xpath(".//*[@id='rg_s']//a/img");

    public GoogleImagesSearchResultPage(WebDriver driver) {
        super();
        this.driver = driver;
    }
    
    public List<WebElement> getAllResults() {
        List<WebElement> elements = driver.findElements(searchResults);
        return elements;
    }
    
    public List<WebElement> getParticularResults(int from, int to){
        List<WebElement> ParticularResults = getAllResults().subList(from, to);
        return ParticularResults;
    }
    

}
