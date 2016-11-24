package academy.softserve.utils;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleChromeDirver implements WebDriver{

    private WebDriver driver;
    
    

    public GoogleChromeDirver(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public GoogleChromeDirver() {
        // TODO Auto-generated constructor stub
    }

    public GoogleChromeDirver setUpDriver() {

        System.setProperty("webdriver.chrome.driver", "srs\\main\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return new GoogleChromeDirver(driver);
    }
    
    

    WebDriver getWebDriver() {
        if (driver != null) {
            return driver;
        } else {
            // TODO Create class Exception + log + report.
            throw new RuntimeException("Browser not found.");
        }
    }

    public GoogleChromeDirver loadPage(String url) {
        getWebDriver().get(url);
        return new GoogleChromeDirver(getWebDriver());
    }
    
    public void close() {
        getWebDriver().close();
        driver = null;
    }

    public void quit() {
        getWebDriver().quit();
        driver = null;
    }

    @Override
    public WebElement findElement(By arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<WebElement> findElements(By arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void get(String arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getCurrentUrl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPageSource() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getWindowHandle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> getWindowHandles() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Options manage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Navigation navigate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        // TODO Auto-generated method stub
        return null;
    }

}
