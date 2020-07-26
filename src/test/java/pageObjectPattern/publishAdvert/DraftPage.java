package pageObjectPattern.publishAdvert;

import pageObjectPattern.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftPage extends AbstractPage {

    private static final By EDIT_TEXT_DRAFT_ADVERT_LOCATOR = By.xpath("//a[@class='link a-action-link']");

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public CustomizationAdvertPage editAdvert() {
        setWaitForElementVisibility(EDIT_TEXT_DRAFT_ADVERT_LOCATOR);
        softAssert.assertEquals(getDriver().findElement(EDIT_TEXT_DRAFT_ADVERT_LOCATOR).getText(),
                "Редактировать текст");
        getDriver().findElement(EDIT_TEXT_DRAFT_ADVERT_LOCATOR).click();
        return new CustomizationAdvertPage(getDriver());
    }
}
