package com.epam.cdp.kzta2020.pages.search.search_with_photo_selenide_bonus_task;

import com.epam.cdp.kzta2020.common.component.KolesaSearhWithPhotoSelect;
import com.epam.cdp.kzta2020.domain.KolesaSearchWithPhotoData;
import com.epam.cdp.kzta2020.pages.search.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private static final By YEAR_INPUT_LOCATOR = By.id("year[from]");
    private static final By ADDITION_MARKS_LOCATOR = By.xpath("//span[@class='arrow-link']");
    private static final By CHECKBOX_PHOTO_LOCATOR = By.xpath("//label[@for='_sys-hasphoto-checkbox-0']");
    private static final By FOUND_RESULT_LOCATOR = By.cssSelector("a.list-link.ddl_product_link");

    public HomePage configureSearch(KolesaSearchWithPhotoData kolesaSearchWithPhotoData) {
        kolesaSearchWithPhotoData.getPrice().ifPresent(this::fillPrice);
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
        KolesaSearhWithPhotoSelect kolesaSearhWithPhotoSelect = new KolesaSearhWithPhotoSelect(driver,ADDITION_MARKS_LOCATOR);
        kolesaSearhWithPhotoSelect.selectMark(mark);
        return this;
    }

    public HomePage enablePhotoCheckbox() {
        waitForElementEnabled(CHECKBOX_PHOTO_LOCATOR);
        driver.findElement(CHECKBOX_PHOTO_LOCATOR).click();
        return this;
    }

    public HomePage openFoundResult() {
        waitForElementVisibility(FOUND_RESULT_LOCATOR);
        driver.findElement(FOUND_RESULT_LOCATOR).click();
        return this;
    }
}
