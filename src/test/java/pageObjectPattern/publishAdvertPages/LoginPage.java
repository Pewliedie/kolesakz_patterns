package pageObjectPattern.publishAdvertPages;

import pageObjectPattern.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

    private static final By PHONE_NUMBER_INPUT_LOCATOR = By.id("login");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector(".form-item button");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillNumberInput(String number) {
        setWaitForElementVisibility(PHONE_NUMBER_INPUT_LOCATOR);
        getDriver().findElement(PHONE_NUMBER_INPUT_LOCATOR).sendKeys(number);
        return this;
    }

    public LoginPage clickLoginButton() {
        getDriver().findElement(LOGIN_BUTTON_LOCATOR).click();
        isAlertPresent();
        return this;
    }

    public LoginPage fillPasswordInput(String password) {
        setWaitForElementVisibility(PASSWORD_INPUT_LOCATOR);
        getDriver().findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        return this;
    }

}
