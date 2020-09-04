package com.epam.cdp.kzta2020.pages.search.search_with_basic_parameters;

import com.epam.cdp.kzta2020.domain.SearchWithPhotoData;
import com.epam.cdp.kzta2020.pages.BasePage;
import org.openqa.selenium.By;

public class HomePage extends com.epam.cdp.kzta2020.pages.BasePage {
    private static final By YEAR_INPUT_LOCATOR = By.id("year[from]");
    private static final By ADDITION_MARKS_LOCATOR = By.xpath("//span[@class='arrow-link']");
//    private static final By CHECKBOX_PHOTO_LOCATOR = By.xpath("//label[@for='_sys-hasphoto-checkbox-0']");
    private static final By CHECKBOX_PHOTO_LOCATOR = By.xpath("//label[@for='_sys-hasphoto-checkbox']");
    private static final String MARK_LOCATOR = "span[data-alias='%s']";
    private static final By PRICE_INPUT_FROM_LOCATOR = By.id("price[from]");
    private static final By PRICE_INPUT_TO_LOCATOR = By.id("price[to]");
    private static final String CITY_LOCATOR = "//button/span[contains(text(),'%s')]";

    public HomePage configureSearch(SearchWithPhotoData kolesaSearchWithPhotoData) {
        kolesaSearchWithPhotoData.getPriceFrom().ifPresent(this::fillPriceFrom);
        kolesaSearchWithPhotoData.getCity().ifPresent(this::choseLocation);
        kolesaSearchWithPhotoData.getModelYear().ifPresent(this::fillYearModel);
        kolesaSearchWithPhotoData.getMark().ifPresent(this::configureMark);
        return this;
    }

    public BasePage choseLocation(String city) {
        waitForElementEnabled(By.xpath(String.format(CITY_LOCATOR, city)));
        driver.findElement(By.xpath(String.format(CITY_LOCATOR, city))).click();
        return this;
    }

    public HomePage fillYearModel(String year) {
        waitForElementVisibility(YEAR_INPUT_LOCATOR);
        driver.findElement(YEAR_INPUT_LOCATOR).sendKeys(year);
        return this;
    }

    public HomePage configureMark(String mark) {
        waitForElementEnabled(ADDITION_MARKS_LOCATOR);
        driver.findElement(ADDITION_MARKS_LOCATOR).click();
        waitForElementEnabled(By.cssSelector(String.format(MARK_LOCATOR, mark)));
        driver.findElement(By.cssSelector(String.format(MARK_LOCATOR, mark))).click();
        return this;
    }

    public HomePage enablePhotoCheckbox() {
        waitForElementEnabled(CHECKBOX_PHOTO_LOCATOR);
        driver.findElement(CHECKBOX_PHOTO_LOCATOR).click();
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

    public BasePage configureModel(String model) {
        waitForElementEnabled(By.cssSelector(String.format(MARK_LOCATOR, model)));
        driver.findElement(By.cssSelector(String.format(MARK_LOCATOR, model))).click();
        return this;
    }
}
