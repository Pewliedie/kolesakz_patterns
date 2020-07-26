package pageObjectPattern.publishAdvert;

import pageObjectPattern.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChoosePostTypePage extends AbstractPage {

    private static final By PUBLISH_FREE_ADVERT_LOCATOR = By.xpath("//div[contains(text(),'Подать без продвижения')]");
    private static final By CONFIRMATION_TEXT = By.xpath("//h1");

    public ChoosePostTypePage(WebDriver driver) {
        super(driver);
    }

    public ChoosePostTypePage chooseFreeAdvert() {
        setWaitForElementVisibility(PUBLISH_FREE_ADVERT_LOCATOR);
        getDriver().findElement(PUBLISH_FREE_ADVERT_LOCATOR).click();
        return this;
    }

    public ChoosePostTypePage isAdvertSent(){
        setWaitForElementVisibility((CONFIRMATION_TEXT));
        softAssert.assertEquals(getDriver().findElement(CONFIRMATION_TEXT).getText(), "Объявление отправлено на проверку!", "Advert is not posted");
        return this;
    }
}
