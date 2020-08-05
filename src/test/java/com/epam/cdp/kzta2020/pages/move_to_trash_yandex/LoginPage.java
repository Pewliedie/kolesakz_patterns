package com.epam.cdp.kzta2020.pages.move_to_trash_yandex;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends AbstractPage {

    private static final By LOGIN_FIELD = By.cssSelector("#passp-field-login");
    private static final By PASSWORD_FIELD = By.cssSelector("#passp-field-passwd");
    private static final By LOGIN_BUTTON = By.xpath("//button[@class='Button2 Button2_type_submit Button2_width_max Button2_view_action Button2_size_auth-l']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String s, String s2) {
        fillLogin(s);
        clickLogin();
        fillPassword(s2);
        clickLogin();
    }


    public LoginPage fillLogin(String login) {
        waitForElementVisibility(LOGIN_FIELD);
        WebElement loginField = driver.findElement(LOGIN_FIELD);
        new Actions(driver).sendKeys(loginField, login).build().perform();
        return this;
    }

    public LoginPage clickLogin() {
        waitForElementEnabled(LOGIN_BUTTON);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public LoginPage fillPassword(String password) {
        waitForElementVisibility(PASSWORD_FIELD);
        WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        new Actions(getDriver()).sendKeys(passwordField, password).build().perform();
        return this;
    }
}
