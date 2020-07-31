package com.epam.cdp.kzta2020.pages.publish_advert_pages;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class LoggedAccountPage extends AbstractPage {

    private static final By POST_ADVERT_BUTTON_LOCATOR = By.xpath("//a[@class='btn btn-primary a-new-btn js__add-new']");
    private static final By DRAFT_LOCATOR = By.xpath("//li[3]//a[1]//span");
    private static final By LOGGED_ACCOUNT_PAGE_LOCATOR = By.xpath("//span[@class='header-menu-dropdown__toggler-label']");
    private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("//a[@class='header-menu-dropdown__menu-link logout-link']");
    private static final By LOGGED_OUT_ACCOUNT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Личный кабинет')]");

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

    public LoggedAccountPage logOff() {
        waitForElementVisibility(LOGGED_ACCOUNT_PAGE_LOCATOR);
        driver.findElement(LOGGED_ACCOUNT_PAGE_LOCATOR).click();
        waitForElementVisibility(LOGOUT_BUTTON_LOCATOR);
        driver.findElement(LOGOUT_BUTTON_LOCATOR).click();
        waitForElementVisibility(LOGGED_OUT_ACCOUNT_BUTTON_LOCATOR);
        return this;
    }

}
