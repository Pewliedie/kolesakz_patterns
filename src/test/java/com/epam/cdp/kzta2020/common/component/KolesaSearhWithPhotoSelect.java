package com.epam.cdp.kzta2020.common.component;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KolesaSearhWithPhotoSelect extends AbstractPage {

    private By rootElementLocator;

    public KolesaSearhWithPhotoSelect(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectCity(String string) {
        waitForElementEnabled(By.cssSelector(String.format("button[data-alias='%s']", string)));
        getDriver().findElement(By.cssSelector(String.format("button[data-alias='%s']", string))).click();
    }

    public void selectMark(String string) {
        waitForElementEnabled(rootElementLocator);
        getDriver().findElement(rootElementLocator).click();
        waitForElementEnabled(By.cssSelector(String.format("span[data-alias='%s']", string)));
        WebElement element = getDriver().findElement(By.cssSelector(String.format("span[data-alias='%s']", string)));
        element.click();
    }
}
