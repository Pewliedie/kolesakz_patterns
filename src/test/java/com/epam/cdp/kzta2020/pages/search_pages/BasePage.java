package com.epam.cdp.kzta2020.pages.search_pages;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class BasePage extends AbstractPage {
    //div[@class='menu-container container']//li[1]
    //span[data-alias='cars']
    private static final By AUTO_SECTION_LOCATOR = By.xpath("//div[@class='menu-container container']//li[1]");
    private static final By PRICE_INPUT_LOCATOR = By.id("price[from]");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("button.primary-button");


    public BasePage openAutoSection() {
        waitForElementEnabled(AUTO_SECTION_LOCATOR);
        driver.findElement(AUTO_SECTION_LOCATOR).click();
        return this;
    }

    public BasePage fillPrice(String price) {
        waitForElementVisibility(PRICE_INPUT_LOCATOR);
        driver.findElement(PRICE_INPUT_LOCATOR).sendKeys(price);
        return this;
    }

    public BasePage clickSearchButton() {
        driver.findElement(SEARCH_BUTTON_LOCATOR).click();
        return this;
    }

}
