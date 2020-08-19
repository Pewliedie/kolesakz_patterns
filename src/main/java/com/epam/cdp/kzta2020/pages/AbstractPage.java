package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.common.config.Configuration;
import com.epam.cdp.kzta2020.driver.WebDriverInitializer;
import com.epam.cdp.kzta2020.utils.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    private final Configuration configuration = ConfigUtil.getConfiguration();
    public AbstractPage() {
        this.driver = WebDriverInitializer.getDriver();
    }

    public void waitForElementVisibility(By locator) {
        new WebDriverWait(driver, configuration.getWaitForElementTimeoutSecond()).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForElementEnabled(By locator) {
        new WebDriverWait(driver, Configuration.getPageLoadTimeOut()).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}
