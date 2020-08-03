package com.epam.cdp.kzta2020.common.component;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

public class KolesaPostAdSelect extends AbstractPage {

    private By rootElementLocator;

    public KolesaPostAdSelect(WebDriver webDriver) {
        super(webDriver);
    }

    public KolesaPostAdSelect(WebDriver webDriver, By rootElementLocator) {
        super(webDriver);
        this.rootElementLocator = rootElementLocator;
    }

    public void select(String text) {
        waitForElementEnabled(By.xpath(String.format("//label[contains(text(),'%s')]", text)));
        getDriver().findElement(By.xpath(String.format("//label[contains(text(),'%s')]", text))).click();
    }

    public void selectCategory(String text) {
        waitForElementEnabled(By.xpath(String.format("//option[contains(.,'%s')]", text)));
        getDriver().findElement(By.xpath(String.format("//option[contains(.,'%s')]", text))).click();
    }

    public void selectMark(String text) {
        waitForElementEnabled(By.xpath(String.format("//div[contains(text(),'%s')]", text)));
        getDriver().findElement(By.xpath(String.format("//div[contains(text(),'%s')]", text))).click();
    }

    public void selectModel(String text) {
        waitForElementEnabled(By.xpath(String.format("//button[contains(text(),'%s')]", text)));
        getDriver().findElement(By.xpath(String.format("//button[contains(text(),'%s')]", text))).click();
    }

    public void selectEngineModification(String text) {
        waitForElementEnabled(By.xpath(String.format("//span[contains(text(),'%s')]", text)));
        getDriver().findElement(By.xpath(String.format("//span[contains(text(),'%s')]", text))).click();
    }

    public void selectCity(String text) {
        getDriver().findElement(rootElementLocator).click();
        WebElement item = getDriver().findElement(new ByChained(rootElementLocator, By.xpath(String.format("//ul/li[contains(.,'%s')]", text))));
        waitForElementEnabled(By.xpath(String.format("//ul/li[contains(.,'%s')]", text)));
        item.click();
    }
}
