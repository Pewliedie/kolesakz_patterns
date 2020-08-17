package com.epam.cdp.kzta2020.utils;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandler {

    public static void waitForAlertDisplayed(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException | TimeoutException ignored) {
        }
    }
}
