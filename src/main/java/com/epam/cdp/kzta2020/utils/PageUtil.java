package com.epam.cdp.kzta2020.utils;

import com.epam.cdp.kzta2020.driver.WebDriverInitializer;
import org.openqa.selenium.By;

public class PageUtil {
    public static String getText(By locator) {
        return WebDriverInitializer.getDriverInstance().findElement(locator).getText();
    }

    public void higlightAndScreenshot(){
        
    }
}
