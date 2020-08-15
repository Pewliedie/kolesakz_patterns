package com.epam.kzta2020.pages.search.advanced_search;

import com.epam.kzta2020.business_objects.Car;
import com.epam.kzta2020.domain.AdvancedSearchData;
import com.epam.kzta2020.pages.search.BasePage;
import com.epam.kzta2020.utils.ScreenShoter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

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
    private static final String RANDOM_RESULT_LOCATOR = "(//a[@class='list-link ddl_product_link'])[%s]";
    private static final String MARK_LOCATOR = "span[data-alias='%s']";
    private static final String ITEM_SELECTED_LOCATOR = "li[data-label='%s']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage configureAdvancedSearch(AdvancedSearchData advancedSearchData) {
        advancedSearchData.getCity().ifPresent(this::chooseCity);
        advancedSearchData.getPriceFrom().ifPresent(this::fillPriceFrom);
        openAdvancedSearch();
        advancedSearchData.getCountry().ifPresent(this::configureCountry);
        advancedSearchData.getVehicleStatus().ifPresent(this::configureVehicleStatus);
        advancedSearchData.getBodyType().ifPresent(this::configureBodyType);
        advancedSearchData.getEngineType().ifPresent(this::configureEngineType);
        advancedSearchData.getLocationOfWheel().ifPresent(this::configureLocationWheel);
        advancedSearchData.getDriveUnit().ifPresent(this::configureDriveUnit);
        advancedSearchData.getEngineVolumeFrom().ifPresent(this::configureEngineVolumeFrom);
        advancedSearchData.getEngineVolumeTo().ifPresent(this::configureEngineVolumeTO);
        ScreenShoter.takeScreenShoot(driver);
        return this;
    }

    public HomePage configureRandomSearch(Car car) {
        car.getCity().ifPresent(this::chooseCity);
        car.getPriceFrom().ifPresent(this::fillPriceFrom);
        car.getPriceTo().ifPresent(this::fillPriceTO);
        car.getMark().ifPresent(this::configureMark);
        car.getModel().ifPresent(this::configureModel);
        return this;
    }

    public HomePage openAdvancedSearch() {
        waitForElementVisibility(ADVANCED_SEARCH_LOCATOR);
        driver.findElement(ADVANCED_SEARCH_LOCATOR).click();
        return this;
    }

    public HomePage configureCountry(String param) {
        select(param, COUNTRY_PARAMETER_LOCATOR);
        return this;
    }

    public HomePage configureVehicleStatus(String param) {
        select(param, VEHICLE_STATUS_LOCATOR);
        return this;
    }

    public HomePage configureBodyType(String param) {
        select(param, CAR_BODY_TYPE_LOCATOR);
        return this;
    }

    public HomePage configureEngineType(String param) {
        select(param, ENGINE_TYPE_LOCATOR);
        return this;
    }

    public HomePage configureLocationWheel(String param) {
        select(param, LOCATION_OF_WHEEL_LOCATOR);
        return this;
    }

    public HomePage configureDriveUnit(String param) {
        select(param, DRIVE_UNIT_LOCATOR);
        return this;
    }

    public void select(String text, By rootElementLocator) {
        driver.findElement(rootElementLocator).click();
        WebElement element = driver.findElement(new ByChained(rootElementLocator, By.cssSelector(String.format(ITEM_SELECTED_LOCATOR, text))));
        element.click();
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

    public HomePage configureMark(String mark) {
        waitForElementEnabled(By.cssSelector(String.format(MARK_LOCATOR, mark)));
        driver.findElement(By.cssSelector(String.format(MARK_LOCATOR, mark))).click();
        return this;
    }

    public HomePage configureModel(String model) {
        waitForElementEnabled(By.cssSelector(String.format(MARK_LOCATOR, model)));
        driver.findElement(By.cssSelector(String.format(MARK_LOCATOR, model))).click();
        return this;
    }


    public HomePage openRandomFoundResult(String randomNumber) {
        waitForElementVisibility((By.xpath(String.format(RANDOM_RESULT_LOCATOR, randomNumber))));
        driver.findElement(By.xpath(String.format(RANDOM_RESULT_LOCATOR, randomNumber))).click();
        return this;
    }
}
