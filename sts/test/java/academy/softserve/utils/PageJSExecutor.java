package academy.softserve.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageJSExecutor {

    public static void scrollPage(int x, int y, WebDriver driver) {
        String params = "scroll" + "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
        ((JavascriptExecutor) driver).executeScript(params);
    }

    public static void hideObjects(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden'", element);
    }
    
    public static void changeObjectColor (WebElement element, WebDriver driver, String color){
        String scriptName = "arguments[0].style.color='"+color+ "'";
        ((JavascriptExecutor)driver).executeScript(scriptName,element);
    }

}
