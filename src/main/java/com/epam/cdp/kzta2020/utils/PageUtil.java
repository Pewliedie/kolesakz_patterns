package com.epam.cdp.kzta2020.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageUtil{
    public static String getText(By locator, WebDriver driver) {
        return driver.findElement(locator).getText();
    }
}
