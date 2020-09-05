package com.epam.cdp.kzta2020.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandler {
    private static final Logger logger = Logger.getLogger("kolesa_logger");

    public static void waitForAlertDisplayed(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException | TimeoutException e) {
            e.printStackTrace();
            logger.error("exception in alert handler " + e);
        }
    }
}
