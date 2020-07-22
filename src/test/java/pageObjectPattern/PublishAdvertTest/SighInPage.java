package pageObjectPattern.PublishAdvertTest;

import pageObjectPattern.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SighInPage extends AbstractPage {

    private static final By PHONE_NUMBER_INPUT_LOCATOR = By.id("login");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector(".form-item button");


    public SighInPage(WebDriver driver) {
        super(driver);
    }

    public SighInPage fillNumberInput(String number) {
        setWaitForElementVisibility(PHONE_NUMBER_INPUT_LOCATOR);
        getDriver().findElement(PHONE_NUMBER_INPUT_LOCATOR).sendKeys(number);
        return this;
    }

    public SighInPage clickLoginButton() {
        getDriver().findElement(LOGIN_BUTTON_LOCATOR).click();
        isAlertPresent();
        return this;
    }

    public SighInPage fillPasswordInput(String password) {
        isElementPresent(PASSWORD_INPUT_LOCATOR);
        getDriver().findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        return this;
    }

}
