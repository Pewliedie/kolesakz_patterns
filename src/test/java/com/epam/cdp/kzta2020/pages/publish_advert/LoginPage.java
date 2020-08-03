package com.epam.cdp.kzta2020.pages.publish_advert;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {

    private static final By PHONE_NUMBER_INPUT_LOCATOR = By.id("login");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector(".form-item button");



    public LoginPage login(String number,String password){
        fillNumberInput(number);
        clickLoginButton();
        fillPasswordInput(password);
        clickLoginButton();
        return this;
    }


    public LoginPage fillNumberInput(String number) {
        waitForElementVisibility(PHONE_NUMBER_INPUT_LOCATOR);
        driver.findElement(PHONE_NUMBER_INPUT_LOCATOR).sendKeys(number);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
        waitForAlertDisplayed();
        return this;
    }

    public LoginPage fillPasswordInput(String password) {
        waitForElementVisibility(PASSWORD_INPUT_LOCATOR);
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        return this;
    }

}
