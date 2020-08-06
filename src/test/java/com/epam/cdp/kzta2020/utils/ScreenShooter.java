package com.epam.cdp.kzta2020.utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShooter extends AbstractPage {
    public static final String SCREENSHOOTS_NAME_TPL = "screenshots/src";

    public ScreenShooter(WebDriver driver) {
        super(driver);
    }

    public static void takeScreenShoot() {
        File screenShoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenShootName = SCREENSHOOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenShootName + ".png");
            FileUtils.copyFile(screenShoot,copy);
        }catch (IOException e){

        }
    }
}