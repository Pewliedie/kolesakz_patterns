package com.epam.cdp.kzta2020.common.component;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

public class KolesaAdvancedSearchSelect extends AbstractPage {

    private final By rootElementLocator;

    public KolesaAdvancedSearchSelect(By rootElementLocator) {
        this.rootElementLocator = rootElementLocator;
    }

    public void select(String text) {
        driver.findElement(rootElementLocator).click();
        WebElement element = driver.findElement(new ByChained(rootElementLocator, By.cssSelector(String.format("li[data-label='%s']", text))));
        element.click();
    }
}
