package pageObjectPattern.PublishAdvertTest;

import pageObjectPattern.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DraftPage extends AbstractPage {

    private static final By EDIT_TEXT_DRAFRT_ADVERT_LOCATOR = By.xpath("//a[@class='link a-action-link']");
    private static final By ADVERT_ADDED_TIME_LOCATOR = By.xpath("//div[@class='a-info-added']");

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public CustomizationAdvertPage editAdvert() {
        setWaitForElementVisibility(EDIT_TEXT_DRAFRT_ADVERT_LOCATOR);
        setWaitForElementVisibility(ADVERT_ADDED_TIME_LOCATOR);
        Assert.assertTrue(getDriver().findElement(ADVERT_ADDED_TIME_LOCATOR).isDisplayed());
        getDriver().findElement(EDIT_TEXT_DRAFRT_ADVERT_LOCATOR).click();
        return new CustomizationAdvertPage(getDriver());
    }
}
