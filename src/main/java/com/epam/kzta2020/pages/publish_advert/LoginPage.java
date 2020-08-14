package com.epam.kzta2020.pages.publish_advert;

import com.epam.kzta2020.business_objects.User;
import com.epam.kzta2020.pages.AbstractPage;
import com.epam.kzta2020.utils.ScreenShoter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

    private static final By PHONE_NUMBER_INPUT_LOCATOR = By.id("login");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector(".form-item button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage signIn(User user){
        fillNumberInput(user.getLogin());
        clickLoginButton();
        fillPasswordInput(user.getPassword());
        clickLoginButton();
        ScreenShoter.takeScreenShoot(driver);
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