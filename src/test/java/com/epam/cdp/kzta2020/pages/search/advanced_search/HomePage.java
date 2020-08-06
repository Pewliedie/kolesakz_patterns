package com.epam.cdp.kzta2020.pages.search.advanced_search;

import com.epam.cdp.kzta2020.common.component.KolesaAdvancedSearchSelect;
import com.epam.cdp.kzta2020.domain.KolesaAdvancedSearchData;
import com.epam.cdp.kzta2020.pages.search.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By ADVANCED_SEARCH_LOCATOR = By.cssSelector("button.set-optional span.label");
    private static final By COUNTRY_PARAMETER_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-mark-country");
    private static final By VEHICLE_STATUS_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-auto-emergency");
    private static final By CAR_BODY_TYPE_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-auto-car-body");
    private static final By ENGINE_TYPE_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-auto-fuel");
    private static final By LOCATION_OF_WHEEL_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-auto-sweel");
    private static final By DRIVE_UNIT_LOCATOR = By.cssSelector("div.element-group.element-group-parameter-car-dwheel");
    private static final By ENGINE_VOLUME_FROM_LOCATOR = By.cssSelector("#auto-car-volume\\[from\\]");
    private static final By ENGINE_VOLUME_TO_LOCATOR = By.cssSelector("#auto-car-volume\\[to\\]");
    private static final By SEARCH_RESULT_LOCATOR = By.cssSelector("a.list-link.ddl_product_link");

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage configureAdvancedSearch(KolesaAdvancedSearchData kolesaAdvancedSearchData) {
        kolesaAdvancedSearchData.getCity().ifPresent(this::chooseCity);
        kolesaAdvancedSearchData.getPrice().ifPresent(this::fillPrice);
        openAdvancedSearch();
        kolesaAdvancedSearchData.getCountry().ifPresent(this::configureCountry);
        kolesaAdvancedSearchData.getVehicleStatus().ifPresent(this::configureVehicleStatus);
        kolesaAdvancedSearchData.getBodyType().ifPresent(this::configureBodyType);
        kolesaAdvancedSearchData.getEngineType().ifPresent(this::configureEngineType);
        kolesaAdvancedSearchData.getLocationOfWheel().ifPresent(this::configureLocationWheel);
        kolesaAdvancedSearchData.getDriveUnit().ifPresent(this::configureDriveUnit);
        kolesaAdvancedSearchData.getEngineVolumeFrom().ifPresent(this::configureEngineVolumeFrom);
        kolesaAdvancedSearchData.getEngineVolumeTo().ifPresent(this::configureEngineVolumeTO);
        return this;
    }

    public HomePage openAdvancedSearch() {
        waitForElementVisibility(ADVANCED_SEARCH_LOCATOR);
        driver.findElement(ADVANCED_SEARCH_LOCATOR).click();
        return this;
    }

    public HomePage configureCountry(String param) {
        KolesaAdvancedSearchSelect kolesaAdvancedSearchSelect = new KolesaAdvancedSearchSelect(driver, COUNTRY_PARAMETER_LOCATOR);
        kolesaAdvancedSearchSelect.select(param);
        return this;
    }

    public HomePage configureVehicleStatus(String param) {
        KolesaAdvancedSearchSelect kolesaAdvancedSearchSelect = new KolesaAdvancedSearchSelect(driver, VEHICLE_STATUS_LOCATOR);
        kolesaAdvancedSearchSelect.select(param);
        return this;
    }

    public HomePage configureBodyType(String param) {
        KolesaAdvancedSearchSelect kolesaAdvancedSearchSelect = new KolesaAdvancedSearchSelect(driver, CAR_BODY_TYPE_LOCATOR);
        kolesaAdvancedSearchSelect.select(param);
        return this;
    }

    public HomePage configureEngineType(String param) {
        KolesaAdvancedSearchSelect kolesaAdvancedSearchSelect = new KolesaAdvancedSearchSelect(driver, ENGINE_TYPE_LOCATOR);
        kolesaAdvancedSearchSelect.select(param);
        return this;
    }

    public HomePage configureLocationWheel(String param) {
        KolesaAdvancedSearchSelect kolesaAdvancedSearchSelect = new KolesaAdvancedSearchSelect(driver, LOCATION_OF_WHEEL_LOCATOR);
        kolesaAdvancedSearchSelect.select(param);
        return this;
    }

    public HomePage configureDriveUnit(String param) {
        KolesaAdvancedSearchSelect kolesaAdvancedSearchSelect = new KolesaAdvancedSearchSelect(driver, DRIVE_UNIT_LOCATOR);
        kolesaAdvancedSearchSelect.select(param);
        return this;
    }

    public HomePage configureEngineVolumeFrom(String volumeFrom) {
        driver.findElement(ENGINE_VOLUME_FROM_LOCATOR).sendKeys(volumeFrom);
        return this;
    }

    public HomePage configureEngineVolumeTO(String volumeTo) {
        driver.findElement(ENGINE_VOLUME_TO_LOCATOR).sendKeys(volumeTo);
        return this;
    }

    public HomePage openFoundResult() {
        waitForElementVisibility(SEARCH_RESULT_LOCATOR);
        driver.findElement(SEARCH_RESULT_LOCATOR).click();
        return this;
    }
}
