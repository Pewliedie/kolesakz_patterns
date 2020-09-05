package com.epam.cdp.kzta2020.pages.publish_advert;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class DraftPage extends AbstractPage {
    private static final By EDIT_TEXT_DRAFT_ADVERT_LOCATOR = By.cssSelector("a[class='link a-action-link']");


    public CustomizationAdPage editAdvert() {
        waitForElementVisibility(EDIT_TEXT_DRAFT_ADVERT_LOCATOR);
        driver.findElement(EDIT_TEXT_DRAFT_ADVERT_LOCATOR).click();
        logger.info("click edit advert");
        return new CustomizationAdPage();
    }
}
