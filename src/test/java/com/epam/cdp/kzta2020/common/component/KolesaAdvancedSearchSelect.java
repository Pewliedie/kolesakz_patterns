package com.epam.cdp.kzta2020.common.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

public class KolesaAdvancedSearchSelect {

    private final WebDriver webDriver;
    private final By rootElementLocator;

    public KolesaAdvancedSearchSelect(WebDriver webDriver, By rootElementLocator) {
        this.webDriver = webDriver;
        this.rootElementLocator = rootElementLocator;
    }

    public void select(String text) {
        webDriver.findElement(rootElementLocator).click();
        WebElement element = webDriver.findElement(new ByChained(rootElementLocator, By.cssSelector(String.format("li[data-label='%s']", text))));
        element.click();
    }
}
