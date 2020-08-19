package com.epam.cdp.kzta2020.pages.search.search_with_photo;

import com.epam.cdp.kzta2020.domain.SearchWithPhotoData;
import com.epam.cdp.kzta2020.pages.search.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final By YEAR_INPUT_LOCATOR = By.id("year[from]");
    private static final By ADDITION_MARKS_LOCATOR = By.xpath("//span[@class='arrow-link']");
    private static final By CHECKBOX_PHOTO_LOCATOR = By.xpath("//label[@for='_sys-hasphoto-checkbox-0']");
    private static final String MARK_LOCATOR = "span[data-alias='%s']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage configureSearch(SearchWithPhotoData kolesaSearchWithPhotoData) {
        kolesaSearchWithPhotoData.getPriceFrom().ifPresent(this::fillPriceFrom);
        kolesaSearchWithPhotoData.getCity().ifPresent(this::chooseCity);
        kolesaSearchWithPhotoData.getModelYear().ifPresent(this::fillYearModel);
        kolesaSearchWithPhotoData.getMark().ifPresent(this::configureMark);
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
}
