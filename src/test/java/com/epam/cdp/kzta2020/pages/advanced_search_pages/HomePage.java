package com.epam.cdp.kzta2020.pages.advanced_search_pages;

import com.epam.cdp.kzta2020.pages.search_pages.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final By CITY_LOCATOR = By.xpath("//li[1]//button");
    private static final By ADVANCED_SEARCH_LOCATOR = By.cssSelector("button.set-optional span.label");
    private static final By COUNTRY_PARAMETER_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-mark-country");
    private static final By VEHICLE_STATUS_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-auto-emergency");
    private static final By CAR_BODY_TYPE_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-auto-car-body");
    private static final By ENGINE_TYPE_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-auto-fuel");
    private static final By LOCATION_OF_WHEEL_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-auto-sweel");
    private static final By DRIVE_UNIT_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-car-dwheel");
    private static final By ENGINE_VOLUME_FROM_LOCATOR = By.cssSelector("#auto-car-volume\\[from\\]");
    private static final By ENGINE_VOLUME_TO_LOCATOR = By.cssSelector("#auto-car-volume\\[to\\]");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("button.primary-button");
    private static final By SEARCH_RESULT_LOCATOR = By.cssSelector("a.list-link.ddl_product_link");


    public HomePage chooseCity() {
        waitForElementVisibility(CITY_LOCATOR);
        driver.findElement(CITY_LOCATOR).click();
        return this;
    }

    public HomePage openAdvancedSearch() {
        waitForElementVisibility(ADVANCED_SEARCH_LOCATOR);
        driver.findElement(ADVANCED_SEARCH_LOCATOR).click();
        return this;
    }

    public HomePage configureCountry(String param) {
        waitForElementVisibility(COUNTRY_PARAMETER_LOCATOR);
        driver.findElement(COUNTRY_PARAMETER_LOCATOR).click();
        parameter(param).click();
        return this;
    }

    public HomePage configureVehicleStatus(String param) {
        driver.findElement(VEHICLE_STATUS_LOCATOR).click();
        parameter(param).click();
        return this;
    }

    public HomePage configureBodyType(String param) {
        driver.findElement(CAR_BODY_TYPE_LOCATOR).click();
        parameter(param).click();
        return this;
    }

    public HomePage configureEngineType(String param) {
        driver.findElement(ENGINE_TYPE_LOCATOR).click();
        parameter(param).click();
        return this;
    }

    public HomePage configureLocationWheel(String param) {
        driver.findElement(LOCATION_OF_WHEEL_LOCATOR).click();
        parameter(param).click();
        return this;
    }

    public HomePage configureDriveUnit(String param) {
        driver.findElement(DRIVE_UNIT_LOCATOR).click();
        parameter(param).click();
        return this;
    }

    public HomePage configureEngineVolume(String volumeFrom, String volumeTo) {
        driver.findElement(ENGINE_VOLUME_FROM_LOCATOR).sendKeys(volumeFrom);
        driver.findElement(ENGINE_VOLUME_TO_LOCATOR).sendKeys(volumeTo);
        return this;
    }

    public HomePage openFoundResult() {
        waitForElementVisibility(SEARCH_RESULT_LOCATOR);
        driver.findElement(SEARCH_RESULT_LOCATOR).click();
        return this;
    }
}
