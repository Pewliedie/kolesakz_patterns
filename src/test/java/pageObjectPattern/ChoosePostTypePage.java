package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChoosePostTypePage extends AbstractPage {

    private static final By PUBLISH_FREE_ADVERT_LOCATOR = By.xpath("//div[contains(text(),'Подать без продвижения')]");

    public ChoosePostTypePage(WebDriver driver) {
        super(driver);
    }

    public ChoosePostTypePage chooseFreeAdvert() {
        setWaitForElementVisibility(PUBLISH_FREE_ADVERT_LOCATOR);
        getDriver().findElement(PUBLISH_FREE_ADVERT_LOCATOR).click();
        return this;
    }
}
