package com.epam.cdp.kzta2020.pages;

import com.epam.cdp.kzta2020.common.config.Configuration;
import com.epam.cdp.kzta2020.pages.publish_advert.AccountPage;
import com.epam.cdp.kzta2020.pages.publish_advert.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BasePage extends AbstractPage {
    private static final By AUTO_SECTION_LOCATOR = By.cssSelector("span[data-alias=cars]");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("button.primary-button");
    private static final String RANDOM_RESULT_LOCATOR = "(//a[@class='list-link ddl_product_link'])[%s]";
    private static final By FOUND_RESULT_LOCATOR = By.cssSelector("a.list-link.ddl_product_link");
    private static final By PERSONAL_ACCOUNT_PAGE_LOCATOR = By.cssSelector("li.header-menu__list-item:nth-child(2)");
    private static final By LOGGED_ACCOUNT_LOCATOR = By.cssSelector("span[class='header-menu-dropdown__toggler-label']");
    private static final By MY_ADVERTS_LOCATOR = By.xpath("//li[@class='header-menu__list-item']//li[2]");

    public BasePage openHomePage(){
        driver.get(Configuration.getBaseUrl());
        return this;
    }

    public SignInPage openSignIn() {
        driver.findElement(PERSONAL_ACCOUNT_PAGE_LOCATOR).click();
        return new SignInPage();
    }

    public AccountPage openAccountPage() {
        waitForElementVisibility(LOGGED_ACCOUNT_LOCATOR);
        driver.findElement(LOGGED_ACCOUNT_LOCATOR).click();
        driver.findElement(MY_ADVERTS_LOCATOR).click();
        waitForElementVisibility(By.xpath("//div[@class='col-xs-9']"));
        return new AccountPage();
    }


    public BasePage openAutoSection() {
        waitForElementEnabled(AUTO_SECTION_LOCATOR);
        driver.findElement(AUTO_SECTION_LOCATOR).click();
        return this;
    }

    public BasePage openFoundResult() {
        waitForElementVisibility(FOUND_RESULT_LOCATOR);
        WebElement element = driver.findElement(FOUND_RESULT_LOCATOR);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(FOUND_RESULT_LOCATOR).click();
        return this;
    }

    public BasePage openRandomFoundResult(String randomNumber) {
        waitForElementVisibility((By.xpath(String.format(RANDOM_RESULT_LOCATOR, randomNumber))));
        WebElement element = driver.findElement(By.xpath(String.format(RANDOM_RESULT_LOCATOR, randomNumber)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath(String.format(RANDOM_RESULT_LOCATOR, randomNumber))).click();
        return this;
    }

    public BasePage showResult() {
        driver.findElement(SEARCH_BUTTON_LOCATOR).click();
        return this;
    }
}
