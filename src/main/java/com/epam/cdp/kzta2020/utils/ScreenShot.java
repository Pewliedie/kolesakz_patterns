package com.epam.cdp.kzta2020.utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    private static final String SCREENSHOTS_PATH = "screenshots/";

    public static void takeScreenShot(WebDriver driver, String failedStep) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenShotName = SCREENSHOTS_PATH + new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
            File copy = new File(screenShotName + failedStep + ".png");
            FileUtils.copyFile(screenShot, copy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
