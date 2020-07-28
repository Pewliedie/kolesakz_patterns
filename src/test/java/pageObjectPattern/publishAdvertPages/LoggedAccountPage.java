package pageObjectPattern.publishAdvertPages;

import pageObjectPattern.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedAccountPage extends AbstractPage {

    private static final By POST_ADVERT_BUTTON_LOCATOR = By.xpath("//a[@class='btn btn-primary a-new-btn js__add-new']");
    private static final By DRAFT_LOCATOR = By.xpath("//li[3]//a[1]//span");
    private static final By LOGGED_ACCOUNT_PAGE_LOCATOR = By.xpath("//span[@class='header-menu-dropdown__toggler-label']");
    private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("//a[@class='header-menu-dropdown__menu-link logout-link']");
    private static final By LOGGED_OUT_ACCOUNT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Личный кабинет')]");


    public LoggedAccountPage(WebDriver driver) {
        super(driver);
    }

    public CustomizationAdvertPage openCustomization() {
        setWaitForElementVisibility(POST_ADVERT_BUTTON_LOCATOR);
        getDriver().findElement(POST_ADVERT_BUTTON_LOCATOR).click();
        return new CustomizationAdvertPage(getDriver());
    }

    public DraftPage openDraft() {
        setWaitForElementVisibility(DRAFT_LOCATOR);
        getDriver().findElement(DRAFT_LOCATOR).click();

        return new DraftPage(getDriver());
    }


    public LoggedAccountPage isAdvertPresent() {
        softAssert.assertEquals(getDriver().findElement(
                By.xpath("//div[@class='col-xs-9']")).getText(), "Ваши объявления на сайте", "Advert is not posted");
        return this;
    }

    public LoggedAccountPage logOff() {
        setWaitForElementVisibility(LOGGED_ACCOUNT_PAGE_LOCATOR);
        getDriver().findElement(LOGGED_ACCOUNT_PAGE_LOCATOR).click();
        setWaitForElementVisibility(LOGOUT_BUTTON_LOCATOR);
        getDriver().findElement(LOGOUT_BUTTON_LOCATOR).click();

        setWaitForElementVisibility(LOGGED_OUT_ACCOUNT_BUTTON_LOCATOR);
        softAssert.assertEquals(getDriver().findElement(By.xpath("//span[contains(text(),'Личный кабинет')]")).getText(), "Личный кабинет", "Not logged out");
        softAssert.assertAll();
        return this;
    }

}
