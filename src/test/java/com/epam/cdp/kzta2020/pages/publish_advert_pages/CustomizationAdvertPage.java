package com.epam.cdp.kzta2020.pages.publish_advert_pages;

import org.openqa.selenium.JavascriptExecutor;
import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class CustomizationAdvertPage extends AbstractPage {
    private static final By ADVERT_OPTION_1_LOCATOR = By.xpath("//option[1]");
    private static final By ADVERT_OPTION_2_LOCATOR = By.cssSelector("option[value='auto.car']");
    private static final By ADVERT_OPTION_MARK_LOCATOR = By.xpath("//div[contains(text(),'Toyota')]");
    private static final By ADVERT_OPTION_MODEL_LOCATOR = By.xpath("//button[contains(text(),'Camry')]");
    private static final By ADVERT_OPTION_MODEL_YEAR_LOCATOR = By.xpath("//label[contains(text(),'2015')]");
    private static final By ADVERT_OPTION_ENGINE_TYPE_LOCATOR = By.xpath("//div[@class='a-form__input-group']//li[1]//label");
    private static final By ADVERT_OPTION_MODIFICATION_TYPE_LOCATOR = By.xpath("//li[2]//label[1]//div");
    private static final By ADVERT_OPTION_PRICE_INPUT_LOCATOR = By.cssSelector("label[class='ui-input a-form__price']");
    private static final By ADVERT_OPTION_CHOOSE_CITY_LOCATOR = By.xpath("//input[@placeholder='Выберите']");
    private static final By ADVERT_OPTION_CITY_LOCATOR = By.xpath("//ul/li[contains(.,'Караганда')]");
    private static final By ADVERT_OPTION_EMAIL_INPUT_LOCATOR = By.xpath("//label[@class='ui-input a-form__email']");
    private static final By HEADER_LOGO_IMAGE_BUTTON_LOCATOR = By.xpath("//a[@class='header-logo']//img");

    private static final By CONTINUE_CUSTOMIZATION_BUTTON_LOCATOR = By.cssSelector(".ui-button--blue");
    private static final By PUBLISH_ADVERT_BUTTON_LOCATOR = By.cssSelector(".ui-button--shadow");

    public CustomizationAdvertPage configureCategory(){
        waitForElementEnabled(ADVERT_OPTION_1_LOCATOR);
        driver.findElement(ADVERT_OPTION_1_LOCATOR).click();
        waitForElementVisibility(ADVERT_OPTION_2_LOCATOR);
        driver.findElement(ADVERT_OPTION_2_LOCATOR).click();
        return this;
    }

    public CustomizationAdvertPage configureMark(){
        waitForElementEnabled(ADVERT_OPTION_MARK_LOCATOR);
        driver.findElement(ADVERT_OPTION_MARK_LOCATOR).click();
        return this;
    }

    public CustomizationAdvertPage configureModel(){
        waitForElementVisibility(ADVERT_OPTION_MODEL_LOCATOR);
        driver.findElement(ADVERT_OPTION_MODEL_LOCATOR).click();
        return this;
    }
    public CustomizationAdvertPage configureYearModel(){
        waitForElementEnabled(ADVERT_OPTION_MODEL_YEAR_LOCATOR);
        driver.findElement(ADVERT_OPTION_MODEL_YEAR_LOCATOR).click();
        return this;
    }

    public CustomizationAdvertPage configureEngineType(){
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        waitForElementVisibility(ADVERT_OPTION_ENGINE_TYPE_LOCATOR);
        driver.findElement(ADVERT_OPTION_ENGINE_TYPE_LOCATOR).click();
        return this;
    }

    public CustomizationAdvertPage configureModification(){
        waitForElementEnabled(ADVERT_OPTION_MODIFICATION_TYPE_LOCATOR);
        driver.findElement(ADVERT_OPTION_MODIFICATION_TYPE_LOCATOR).click();
        return this;
    }

    public CustomizationAdvertPage fillPrice(String price){
        waitForElementVisibility(ADVERT_OPTION_PRICE_INPUT_LOCATOR);
        driver.findElement(ADVERT_OPTION_PRICE_INPUT_LOCATOR).sendKeys(price);
        return this;
    }

    public CustomizationAdvertPage configureCity(){
        waitForElementVisibility(ADVERT_OPTION_CHOOSE_CITY_LOCATOR);
        driver.findElement(ADVERT_OPTION_CHOOSE_CITY_LOCATOR).click();
        waitForElementVisibility(ADVERT_OPTION_CITY_LOCATOR);
        driver.findElement(ADVERT_OPTION_CITY_LOCATOR).click();
        return this;
    }

    public CustomizationAdvertPage fillEmail(String email){
        waitForElementVisibility(ADVERT_OPTION_EMAIL_INPUT_LOCATOR);
        driver.findElement(ADVERT_OPTION_EMAIL_INPUT_LOCATOR).sendKeys(email);
        return this;
    }

    public MainPage moveToHomePage(){
        waitForElementVisibility(HEADER_LOGO_IMAGE_BUTTON_LOCATOR);
        driver.findElement(HEADER_LOGO_IMAGE_BUTTON_LOCATOR).click();
        return new MainPage();
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
        return new PostTypePage();
    }
}
