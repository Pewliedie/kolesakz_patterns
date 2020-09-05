package com.epam.cdp.kzta2020.pages.publish_advert;

import com.epam.cdp.kzta2020.business_objects.User;
import com.epam.cdp.kzta2020.pages.AbstractPage;
import com.epam.cdp.kzta2020.utils.AlertHandler;
import org.openqa.selenium.By;

public class SignInPage extends AbstractPage {

    private static final By PHONE_NUMBER_INPUT_LOCATOR = By.id("login");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector(".form-item button");

    public SignInPage signIn(User user){
        fillNumberInput(user.getLogin());
        clickLoginButton();
        fillPassword(user.getPassword());
        clickLoginButton();
        return this;
    }

    public SignInPage fillNumberInput(String number) {
        waitForElementVisibility(PHONE_NUMBER_INPUT_LOCATOR);
        driver.findElement(PHONE_NUMBER_INPUT_LOCATOR).sendKeys(number);
        logger.info("fill login");
        return this;
    }

    public SignInPage clickLoginButton() {
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
        AlertHandler.waitForAlertDisplayed(driver);
        return this;
    }

    public SignInPage fillPassword(String password) {
        waitForElementVisibility(PASSWORD_INPUT_LOCATOR);
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        logger.info("fill password");
        return this;
    }
}
