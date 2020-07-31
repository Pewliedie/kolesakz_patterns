package com.epam.cdp.kzta2020.pages.search_with_photo_pages;

import com.epam.cdp.kzta2020.pages.search_pages.BasePage;
import org.openqa.selenium.By;

public class HomePageSearch extends BasePage {
    private static final By CITY_LOCATOR = By.xpath("//li[4]//button");
    private static final By YEAR_INPUT_LOCATOR = By.id("year[from]");
    private static final By ADDITION_MARKS_LOCATOR = By.xpath("//span[7]//span");
    private static final By MARK_LOCATOR = By.xpath("//span[contains(text(),'BMW')]");
    private static final By CHECKBOX_PHOTO_LOCATOR = By.xpath("//label[@for='_sys-hasphoto-checkbox-0']");
    private static final By FOUND_RESULT_LOCATOR = By.xpath("//a[contains(text(),'BMW X6 M')]");

    public HomePageSearch chooseCity() {
        waitForElementVisibility(CITY_LOCATOR);
        driver.findElement(CITY_LOCATOR).click();
        return this;
    }

    public HomePageSearch fillYearModel(String year){
        waitForElementVisibility(YEAR_INPUT_LOCATOR);
        driver.findElement(YEAR_INPUT_LOCATOR).sendKeys(year);
        return this;
    }

    public HomePageSearch configureMark(){
        driver.findElement(ADDITION_MARKS_LOCATOR).click();
        driver.findElement(MARK_LOCATOR).click();
        return this;
    }

    public HomePageSearch withPhoto(){
        waitForElementEnabled(CHECKBOX_PHOTO_LOCATOR);
        driver.findElement(CHECKBOX_PHOTO_LOCATOR).click();
        return this;
    }

    public HomePageSearch openFoundResult(){
        waitForElementVisibility(FOUND_RESULT_LOCATOR);
        driver.findElement(FOUND_RESULT_LOCATOR).click();
        return this;
    }
}