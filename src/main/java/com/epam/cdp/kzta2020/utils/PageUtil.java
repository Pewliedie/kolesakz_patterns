package com.epam.cdp.kzta2020.utils;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class PageUtil extends AbstractPage {
    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
