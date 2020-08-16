package com.epam.cdp.kzta2020.utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public static final String SCREENSHOTS_NAME_TPL = "screenshots/src";

    public static void takeScreenShot(WebDriver driver) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenShootName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenShootName + ".png");
            FileUtils.copyFile(screenShot, copy);
        } catch (IOException ignored) {
        }
    }

    public static void highlightAndTakeScreenShot(WebDriver driver, By locator) {
        JsExecutorUtils.highlightElement(driver,locator);
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenShootName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenShootName + ".png");
            FileUtils.copyFile(screenShot, copy);
        } catch (IOException ignored) {
        }
    }
}
