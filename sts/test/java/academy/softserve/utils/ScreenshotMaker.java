package academy.softserve.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotMaker {

    public static void takeIt(WebDriver driver) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
        Date date = new Date();
        String fileName = "srs/main/screenshots/" + "screenshot_" + dateFormat.format(date) + ".png";

        try {
            FileUtils.copyFile(screenShot, new File(fileName));
        } catch (IOException e) {
            System.out.println("Error occurred while taking screenshot");
            e.printStackTrace();
        }
    }
}
