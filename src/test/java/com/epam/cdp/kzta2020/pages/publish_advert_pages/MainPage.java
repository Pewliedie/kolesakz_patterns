package com.epam.cdp.kzta2020.pages.publish_advert_pages;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class MainPage extends AbstractPage {
    private static final By PERSONAL_ACCOUNT_PAGE_LOCATOR = By.cssSelector("li.header-menu__list-item:nth-child(2)");
    private static final By LOGGED_ACCOUNT_LOCATOR = By.cssSelector("span[class='header-menu-dropdown__toggler-label']");
    private static final By MY_ADVERTS_LOCATOR = By.xpath("//li[@class='header-menu__list-item']//li[2]");

    private static final String UNLOGGED_PERSONAL_ACCOUNT_TEXT = "Личный кабинет";



    public LoginPage openLogInPage() {
        driver.findElement(PERSONAL_ACCOUNT_PAGE_LOCATOR).click();
        return new LoginPage();
    }

    public AccountPage openAccountPage() {
        waitForElementVisibility(LOGGED_ACCOUNT_LOCATOR);
        driver.findElement(LOGGED_ACCOUNT_LOCATOR).click();
        driver.findElement(MY_ADVERTS_LOCATOR).click();
        waitForElementVisibility(By.xpath("//div[@class='col-xs-9']"));
        return new AccountPage();
    }

    public boolean isLoggedOut(){
        return driver.findElement(PERSONAL_ACCOUNT_PAGE_LOCATOR).getText().equals(UNLOGGED_PERSONAL_ACCOUNT_TEXT);
    }
}
