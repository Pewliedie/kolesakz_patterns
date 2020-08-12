package com.epam.cdp.kzta2020.pages.publish_advert;

import com.epam.cdp.kzta2020.common.component.KolesaPostAdSelect;
import com.epam.cdp.kzta2020.domain.KolesaPostAdData;
import com.epam.cdp.kzta2020.pages.AbstractPage;
import com.epam.cdp.kzta2020.utils.ScreenShoter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CustomizationAdvertPage extends AbstractPage {
    private static final By ADVERT_OPTION_PRICE_INPUT_LOCATOR = By.cssSelector("label[class='ui-input a-form__price']");
    private static final By ADVERT_OPTION_CHOOSE_CITY_LOCATOR = By.xpath("//input[@placeholder='Выберите']");
    private static final By ADVERT_OPTION_EMAIL_INPUT_LOCATOR = By.xpath("//label[@class='ui-input a-form__email']");
    private static final By HEADER_LOGO_IMAGE_BUTTON_LOCATOR = By.xpath("//a[@class='header-logo']//img");
    private static final By CONTINUE_CUSTOMIZATION_BUTTON_LOCATOR = By.cssSelector(".ui-button--blue");
    private static final By PUBLISH_ADVERT_BUTTON_LOCATOR = By.cssSelector(".ui-button--shadow");

    public CustomizationAdvertPage(WebDriver driver) {
        super(driver);
    }


    public CustomizationAdvertPage customizeAdvert(KolesaPostAdData kolesaPostAdData) {
        kolesaPostAdData.getCategory1().ifPresent(this::configureCategory1);
        kolesaPostAdData.getCategory2().ifPresent(this::configureCategory2);
        kolesaPostAdData.getMark().ifPresent(this::configureMark);
        kolesaPostAdData.getModel().ifPresent(this::configureModel);
        kolesaPostAdData.getModelYear().ifPresent(this::configureModelYear);
        kolesaPostAdData.getEngineType().ifPresent(this::configureEngineType);
        kolesaPostAdData.getEngineModification().ifPresent(this::configureModification);
        kolesaPostAdData.getPrice().ifPresent(this::fillPrice);
        kolesaPostAdData.getCity().ifPresent(this::configureCity);
        kolesaPostAdData.getEmail().ifPresent(this::fillEmail);
        ScreenShoter.takeScreenShoot(driver);
        return this;
    }

    private final KolesaPostAdSelect kolesaPostAdSelect = new KolesaPostAdSelect(driver);

    public CustomizationAdvertPage configureCategory1(String category1) {
        kolesaPostAdSelect.selectCategory(category1);
        return this;
    }

    public CustomizationAdvertPage configureCategory2(String category2) {
        kolesaPostAdSelect.selectCategory(category2);
        return this;
    }

    public CustomizationAdvertPage configureMark(String mark) {
        kolesaPostAdSelect.selectMark(mark);
        return this;
    }

    public CustomizationAdvertPage configureModel(String model) {
        kolesaPostAdSelect.selectModel(model);
        return this;
    }

    public CustomizationAdvertPage configureModelYear(String year) {
        kolesaPostAdSelect.select(year);
        return this;
    }

    public CustomizationAdvertPage configureEngineType(String type) {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        kolesaPostAdSelect.select(type);
        return this;
    }

    public CustomizationAdvertPage configureModification(String modification) {
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");
        kolesaPostAdSelect.selectEngineModification(modification);
        return this;
    }

    public CustomizationAdvertPage fillPrice(String price) {
        waitForElementVisibility(ADVERT_OPTION_PRICE_INPUT_LOCATOR);
        driver.findElement(ADVERT_OPTION_PRICE_INPUT_LOCATOR).sendKeys(price);
        return this;
    }

    public CustomizationAdvertPage configureCity(String city) {
        KolesaPostAdSelect kolesaPostSelect = new KolesaPostAdSelect(driver, ADVERT_OPTION_CHOOSE_CITY_LOCATOR);
        kolesaPostSelect.selectCity(city);
        return this;
    }

    public CustomizationAdvertPage fillEmail(String email) {
        waitForElementVisibility(ADVERT_OPTION_EMAIL_INPUT_LOCATOR);
        driver.findElement(ADVERT_OPTION_EMAIL_INPUT_LOCATOR).sendKeys(email);
        return this;
    }

    public HomePage returnToHomePage() {
        waitForElementVisibility(HEADER_LOGO_IMAGE_BUTTON_LOCATOR);
        driver.findElement(HEADER_LOGO_IMAGE_BUTTON_LOCATOR).click();
        return new HomePage(getDriver());
    }

    public CustomizationAdvertPage postAdvertFromCustomization() {
        waitForElementVisibility(CONTINUE_CUSTOMIZATION_BUTTON_LOCATOR);
        driver.findElement(CONTINUE_CUSTOMIZATION_BUTTON_LOCATOR).click();
        return this;
    }

    public PostTypePage chooseType() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        waitForElementVisibility(PUBLISH_ADVERT_BUTTON_LOCATOR);
        driver.findElement(PUBLISH_ADVERT_BUTTON_LOCATOR).click();
        return new PostTypePage(getDriver());
    }
}
