package com.epam.cdp.kzta2020.pages.publish_advert_pages;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class AccountPage extends AbstractPage {

    private static final By POST_ADVERT_BUTTON_LOCATOR = By.cssSelector("[class='btn btn-primary a-new-btn js__add-new']");
    private static final By DRAFT_LOCATOR = By.xpath("//li[3]//a[1]//span");
    private static final By LOGGED_ACCOUNT_PAGE_LOCATOR = By.xpath("//span[@class='header-menu-dropdown__toggler-label']");
    private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("//a[@class='header-menu-dropdown__menu-link logout-link']");
    private static final By LOGGED_OUT_ACCOUNT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Личный кабинет')]");
    private static final By ADVERTS_ON_PAGE_TEXT_LOCATOR = By.xpath("//div[@class='col-xs-9']");

    private static final String ADVERTS_ON_PAGE_TEXT = "Ваши объявления на сайте";


    public CustomizationAdvertPage openCustomization() {
        waitForElementVisibility(POST_ADVERT_BUTTON_LOCATOR);
        driver.findElement(POST_ADVERT_BUTTON_LOCATOR).click();
        return new CustomizationAdvertPage();
    }

    public DraftPage openDraft() {
        waitForElementVisibility(DRAFT_LOCATOR);
        driver.findElement(DRAFT_LOCATOR).click();
        return new DraftPage();
    }

    public AccountPage logOff() {
        waitForElementVisibility(LOGGED_ACCOUNT_PAGE_LOCATOR);
        driver.findElement(LOGGED_ACCOUNT_PAGE_LOCATOR).click();
        waitForElementVisibility(LOGOUT_BUTTON_LOCATOR);
        driver.findElement(LOGOUT_BUTTON_LOCATOR).click();
        waitForElementVisibility(LOGGED_OUT_ACCOUNT_BUTTON_LOCATOR);
        return this;
    }

    public boolean isAdvertPosted(){
        return driver.findElement(ADVERTS_ON_PAGE_TEXT_LOCATOR).getText().equals(ADVERTS_ON_PAGE_TEXT);
    }

}
