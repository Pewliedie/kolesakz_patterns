package com.epam.cdp.kzta2020.pages.publish_advert_pages;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class ChoosePostTypePage extends AbstractPage {

    private static final By PUBLISH_FREE_ADVERT_LOCATOR = By.xpath("//div[contains(text(),'Подать без продвижения')]");

    public ChoosePostTypePage chooseFreeAdvert() {
        waitForElementVisibility(PUBLISH_FREE_ADVERT_LOCATOR);
        driver.findElement(PUBLISH_FREE_ADVERT_LOCATOR).click();
        return this;
    }
}
