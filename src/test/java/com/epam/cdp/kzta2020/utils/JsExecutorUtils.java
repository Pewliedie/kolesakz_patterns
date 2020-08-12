package com.epam.cdp.kzta2020.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsExecutorUtils{
    public static void highlightElement(WebDriver driver, By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(locator));
    }
}
