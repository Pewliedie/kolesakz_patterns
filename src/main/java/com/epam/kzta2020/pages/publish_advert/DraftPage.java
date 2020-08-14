package com.epam.kzta2020.pages.publish_advert;

import com.epam.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftPage extends AbstractPage {
    private static final By EDIT_TEXT_DRAFT_ADVERT_LOCATOR = By.cssSelector("a[class='link a-action-link']");

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public CustomizationAdvertPage editAdvert() {
        waitForElementVisibility(EDIT_TEXT_DRAFT_ADVERT_LOCATOR);
        driver.findElement(EDIT_TEXT_DRAFT_ADVERT_LOCATOR).click();
        return new CustomizationAdvertPage(getDriver());
    }
}
