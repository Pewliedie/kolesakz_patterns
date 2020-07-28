package pageObjectPattern.publishAdvertPages;

import pageObjectPattern.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    private static final By PERSONAL_ACCOUNT_PAGE_LOCATOR = By.xpath("//header//li[2]//a[1]//span");
    private static final By LOGGED_ACCOUNT_LOCATOR = By.xpath("//span[@class='header-menu-dropdown__toggler-label']");
    private static final By MY_ADVERTS_LOCATOR = By.xpath("//li[@class='header-menu__list-item']//li[2]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLogInPage() {
        getDriver().findElement(PERSONAL_ACCOUNT_PAGE_LOCATOR).click();
        return new LoginPage(getDriver());
    }

    public LoggedAccountPage openMyAdverts() {
        setWaitForElementVisibility(LOGGED_ACCOUNT_LOCATOR);
        getDriver().findElement(LOGGED_ACCOUNT_LOCATOR).click();
        getDriver().findElement(MY_ADVERTS_LOCATOR).click();

        return new LoggedAccountPage(getDriver());
    }
}