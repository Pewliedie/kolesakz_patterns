package com.epam.cdp.kzta2020.utils;


import com.epam.cdp.kzta2020.driver.WebDriverSingleton;
import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShooter{
    public static final String SCREENSHOOTS_NAME_TPL = "screenshots/src";

    public static void takeScreenShoot() {
        File screenShoot = ((TakesScreenshot) WebDriverSingleton.getDriverInstance()).getScreenshotAs(OutputType.FILE);
        try {
            String screenShootName = SCREENSHOOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenShootName + ".png");
            FileUtils.copyFile(screenShoot,copy);
        }catch (IOException e){
        }
    }
}
