package com.epam.cdp.kzta2020.pages.publish_advert;

import com.epam.cdp.kzta2020.domain.PostAdData;
import com.epam.cdp.kzta2020.pages.AbstractPage;
import com.epam.cdp.kzta2020.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

public class CustomizationAdPage extends AbstractPage {
    private static final By ADVERT_OPTION_PRICE_INPUT_LOCATOR = By.cssSelector("label[class='ui-input a-form__price']");
    private static final By ADVERT_OPTION_CHOOSE_CITY_LOCATOR = By.xpath("//input[@placeholder='Выберите']");
    private static final By ADVERT_OPTION_EMAIL_INPUT_LOCATOR = By.xpath("//label[@class='ui-input a-form__email']");
    private static final By HEADER_LOGO_IMAGE_BUTTON_LOCATOR = By.xpath("//a[@class='header-logo']//img");
    private static final By CONTINUE_CUSTOMIZATION_BUTTON_LOCATOR = By.cssSelector("[class='kl-ui-button a-form-confirm__button kl-ui-button--blue']");
    private static final By PUBLISH_ADVERT_BUTTON_LOCATOR = By.cssSelector("[class='kl-ui-button a-form-submit__button kl-ui-button--blue kl-ui-button--shadow']");
    private static final String CATEGORY_LOCATOR = "//option[contains(.,'%s')]";
    private static final String MARK_LOCATOR = "//div[contains(text(),'%s')]";
    private static final String MODEL_YEAR_LOCATOR = "//label[contains(text(),'%s')]";
    private static final String MODEL_LOCATOR = "//button[contains(text(),'%s')]";
    private static final String MODIFICATION_LOCATOR = "//span[contains(text(),'%s')]";
    private static final String CITY_LOCATOR = "//ul/li[contains(.,'%s')]";
    private static final String ENGINE_TYPE_LOCATOR = "//label[contains(text(),'%s')]";

    public CustomizationAdPage customizeAdvert(PostAdData kolesaPostAdData) {
        kolesaPostAdData.getCategory1().ifPresent(this::configureCategory1);
        kolesaPostAdData.getCategory2().ifPresent(this::configureCategory2);
        kolesaPostAdData.getMark().ifPresent(this::configureMark);
        kolesaPostAdData.getModel().ifPresent(this::configureModel);
        kolesaPostAdData.getModelYear().ifPresent(this::configureModelYear);
        kolesaPostAdData.getEngineType().ifPresent(this::configureEngineType);
        kolesaPostAdData.getEngineModification().ifPresent(this::configureModification);
        kolesaPostAdData.getPriceFrom().ifPresent(this::fillPrice);
        kolesaPostAdData.getCity().ifPresent(this::configureCity);
        kolesaPostAdData.getEmail().ifPresent(this::fillEmail);
        return this;
    }


    public CustomizationAdPage configureCategory1(String category1) {
        waitForElementEnabled(By.xpath(String.format(CATEGORY_LOCATOR, category1)));
        driver.findElement(By.xpath(String.format(CATEGORY_LOCATOR, category1))).click();
        return this;
    }

    public CustomizationAdPage configureCategory2(String category2) {
        waitForElementEnabled(By.xpath(String.format(CATEGORY_LOCATOR, category2)));
        driver.findElement(By.xpath(String.format(CATEGORY_LOCATOR, category2))).click();
        return this;
    }

    public CustomizationAdPage configureMark(String mark) {
        waitForElementEnabled(By.xpath(String.format(MARK_LOCATOR, mark)));
        driver.findElement(By.xpath(String.format(MARK_LOCATOR, mark))).click();
        return this;
    }

    public CustomizationAdPage configureModel(String model) {
        waitForElementEnabled(By.xpath(String.format(MODEL_LOCATOR, model)));
        driver.findElement(By.xpath(String.format(MODEL_LOCATOR, model))).click();
        return this;
    }

    public CustomizationAdPage configureModelYear(String year) {
        waitForElementEnabled(By.xpath(String.format(MODEL_YEAR_LOCATOR, year)));
        driver.findElement(By.xpath(String.format(MODEL_YEAR_LOCATOR, year))).click();
        return this;
    }

    public CustomizationAdPage configureEngineType(String type) {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        waitForElementEnabled(By.xpath(String.format(ENGINE_TYPE_LOCATOR, type)));
        driver.findElement(By.xpath(String.format(ENGINE_TYPE_LOCATOR, type))).click();
        return this;
    }

    public CustomizationAdPage configureModification(String modification) {
        waitForElementEnabled(By.xpath(String.format(MODIFICATION_LOCATOR, modification)));
        driver.findElement(By.xpath(String.format(MODIFICATION_LOCATOR, modification))).click();
        return this;
    }

    public CustomizationAdPage fillPrice(String price) {
        waitForElementVisibility(ADVERT_OPTION_PRICE_INPUT_LOCATOR);
        driver.findElement(ADVERT_OPTION_PRICE_INPUT_LOCATOR).sendKeys(price);
        return this;
    }

    public CustomizationAdPage configureCity(String city) {
        driver.findElement(ADVERT_OPTION_CHOOSE_CITY_LOCATOR).click();
        WebElement item = driver.findElement(new ByChained(ADVERT_OPTION_CHOOSE_CITY_LOCATOR, By.xpath(String.format("//ul/li[contains(.,'%s')]", city))));
        waitForElementEnabled(By.xpath(String.format(CITY_LOCATOR, city)));
        item.click();
        return this;
    }

    public CustomizationAdPage fillEmail(String email) {
        waitForElementVisibility(ADVERT_OPTION_EMAIL_INPUT_LOCATOR);
        driver.findElement(ADVERT_OPTION_EMAIL_INPUT_LOCATOR).sendKeys(email);
        return this;
    }

    public BasePage returnOnHomePage() {
        waitForElementVisibility(HEADER_LOGO_IMAGE_BUTTON_LOCATOR);
        driver.findElement(HEADER_LOGO_IMAGE_BUTTON_LOCATOR).click();
        return new BasePage();
    }

    public CustomizationAdPage postAdvertFromCustomization() {
        waitForElementVisibility(CONTINUE_CUSTOMIZATION_BUTTON_LOCATOR);
        driver.findElement(CONTINUE_CUSTOMIZATION_BUTTON_LOCATOR).click();
        return this;
    }

    public PostTypePage chooseType() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        waitForElementVisibility(PUBLISH_ADVERT_BUTTON_LOCATOR);
        driver.findElement(PUBLISH_ADVERT_BUTTON_LOCATOR).click();
        return new PostTypePage();
    }
}
