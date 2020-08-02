package com.epam.cdp.kzta2020.pages.publish_advert_pages;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class MainPage extends AbstractPage {
    private static final By PERSONAL_ACCOUNT_PAGE_LOCATOR = By.xpath("//header//li[2]//a[1]//span");
    private static final By LOGGED_ACCOUNT_LOCATOR = By.xpath("//span[@class='header-menu-dropdown__toggler-label']");
    private static final By MY_ADVERTS_LOCATOR = By.xpath("//li[@class='header-menu__list-item']//li[2]");



    public LoginPage openLogInPage() {
        driver.findElement(PERSONAL_ACCOUNT_PAGE_LOCATOR).click();
        return new LoginPage();
    }

    public LoggedAccountPage openMyAdverts() {
        waitForElementVisibility(LOGGED_ACCOUNT_LOCATOR);
        driver.findElement(LOGGED_ACCOUNT_LOCATOR).click();
        driver.findElement(MY_ADVERTS_LOCATOR).click();
        waitForElementVisibility(By.xpath("//div[@class='col-xs-9']"));
        return new LoggedAccountPage();
    }
}
