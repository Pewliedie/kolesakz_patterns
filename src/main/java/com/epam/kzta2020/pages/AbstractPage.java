package com.epam.kzta2020.pages;

import com.epam.kzta2020.common.config.ConfigReader;
import com.epam.kzta2020.common.config.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected static WebDriver driver;
    private final Configuration configuration = ConfigReader.getConfiguration();

    public AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void waitForElementVisibility(By locator) {
        new WebDriverWait(driver, configuration.getWaitForElementTimeoutSecond()).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForElementEnabled(By locator) {
        new WebDriverWait(driver, configuration.getPageLoadTimeOut()).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForAlertDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException | TimeoutException ignored) {
        }
    }
}
