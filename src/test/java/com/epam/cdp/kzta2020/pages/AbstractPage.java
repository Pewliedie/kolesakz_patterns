package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.config.Configuration;
import com.epam.cdp.kzta2020.utils.WebDriverSetUp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage() {
        this.driver = WebDriverSetUp.getDriverInstance();
    }


    public void waitForElementVisibility(By locator) {
        new WebDriverWait(driver, Configuration.getWaitForElementTimeoutSecond()).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForElementEnabled(By locator) {
        new WebDriverWait(driver, Configuration.getPageLoadTimeOut()).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement parameter(String str){
        return driver.findElement(By.xpath(String.format("//li[contains(.,'%s')]", str)));
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
