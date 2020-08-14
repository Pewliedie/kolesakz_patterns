package com.epam.kzta2020.pages.search.search_with_photo_selenide_bonus_task;

import com.codeborne.selenide.Condition;
import com.epam.kzta2020.domain.SearchWithPhotoData;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private static final By YEAR_INPUT_LOCATOR = By.id("year[from]");
    private static final By ADDITION_MARKS_LOCATOR = By.xpath("//span[@class='arrow-link']");
    private static final By AUTO_SECTION_LOCATOR = By.cssSelector("span[data-alias=cars]");
    private static final By PRICE_INPUT_LOCATOR = By.id("price[from]");
    private static final By CHECKBOX_PHOTO_LOCATOR = By.xpath("//label[@for='_sys-hasphoto-checkbox-0']");
    private static final By FOUND_RESULT_LOCATOR = By.cssSelector("a.list-link.ddl_product_link");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("button.primary-button");

    public HomePage configureSearch(SearchWithPhotoData kolesaSearchWithPhotoData) {
        kolesaSearchWithPhotoData.getPrice().ifPresent(this::fillPrice);
        kolesaSearchWithPhotoData.getCity().ifPresent(this::chooseCity);
        kolesaSearchWithPhotoData.getModelYear().ifPresent(this::fillYearModel);
        kolesaSearchWithPhotoData.getMark().ifPresent(this::configureMark);
        return this;
    }

    public HomePage fillYearModel(String year) {
        $(YEAR_INPUT_LOCATOR).shouldBe(Condition.visible).sendKeys(year);
        return this;
    }

    public HomePage openAutoSection() {
        $(AUTO_SECTION_LOCATOR).shouldBe(Condition.enabled).click();
        return this;
    }

    public HomePage configureMark(String mark) {
        $(ADDITION_MARKS_LOCATOR).shouldBe(Condition.enabled).click();
        $(By.cssSelector(String.format("span[data-alias='%s']", mark))).click();
        return this;
    }

    public HomePage enablePhotoCheckbox() {
        $(CHECKBOX_PHOTO_LOCATOR).shouldBe(Condition.enabled).click();
        return this;
    }

    public HomePage chooseCity(String city) {
        $(By.cssSelector(String.format("button[data-alias='%s']", city))).shouldBe(Condition.visible).click();
        return this;
    }

    public HomePage fillPrice(String price) {
        $(PRICE_INPUT_LOCATOR).shouldBe(Condition.visible).sendKeys(price);
        return this;
    }

    public HomePage openFoundResult() {
        $(FOUND_RESULT_LOCATOR).shouldBe(Condition.visible).click();
        return this;
    }

    public HomePage showResult() {
        $(SEARCH_BUTTON_LOCATOR).click();
        return this;
    }
}
