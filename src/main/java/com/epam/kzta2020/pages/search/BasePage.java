package com.epam.kzta2020.pages.search;

import com.epam.kzta2020.pages.AbstractPage;
import com.epam.kzta2020.utils.ScreenShoter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends AbstractPage {
    private static final By AUTO_SECTION_LOCATOR = By.cssSelector("span[data-alias=cars]");
    private static final By PRICE_INPUT_FROM_LOCATOR = By.id("price[from]");
    private static final By PRICE_INPUT_TO_LOCATOR = By.id("price[to]");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("button.primary-button");
    private static final String CITY_LOCATOR = "//button/span[contains(text(),'%s')]";

    public BasePage(WebDriver driver) {
        super(driver);
    }


    public BasePage openAutoSection() {
        waitForElementEnabled(AUTO_SECTION_LOCATOR);
        ScreenShoter.takeScreenShoot(driver);
        driver.findElement(AUTO_SECTION_LOCATOR).click();
        return this;
    }

    public BasePage chooseCity(String city) {
        waitForElementEnabled(By.xpath(String.format(CITY_LOCATOR, city)));
        getDriver().findElement(By.xpath(String.format(CITY_LOCATOR, city))).click();
        return this;
    }

    public BasePage fillPriceFrom(String price) {
        waitForElementVisibility(PRICE_INPUT_FROM_LOCATOR);
        driver.findElement(PRICE_INPUT_FROM_LOCATOR).sendKeys(price);
        return this;
    }

    public BasePage fillPriceTO(String priceTO) {
        waitForElementVisibility(PRICE_INPUT_TO_LOCATOR);
        driver.findElement(PRICE_INPUT_TO_LOCATOR).sendKeys(priceTO);
        return this;
    }

    public BasePage showResult() {
        driver.findElement(SEARCH_BUTTON_LOCATOR).click();
        return this;
    }
}
