package academy.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePropertiesPage {

    WebDriver driver;

    By checkBox = By.xpath(".//*[@id='instant-radio']/div[3]/span");
    By saveSettingsButton = By.xpath(".//*[@id='form-buttons']/div[1]");

    public GooglePropertiesPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public GooglePropertiesPage openPage(){
        driver.get("http://www.google.com.ua/preferences");
        return this;
        
    }

    public WebElement getCheckBox() {
        return driver.findElement(checkBox);
    }

    public WebElement getSaveButton() {
        return driver.findElement(saveSettingsButton);
    }


}
