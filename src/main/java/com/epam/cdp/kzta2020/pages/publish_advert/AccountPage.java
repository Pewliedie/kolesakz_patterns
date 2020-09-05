package com.epam.cdp.kzta2020.pages.publish_advert;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;

public class AccountPage extends AbstractPage {

    private static final By POST_ADVERT_BUTTON_LOCATOR = By.cssSelector("[class='btn btn-primary a-new-btn js__add-new']");
    private static final By DRAFT_LOCATOR = By.xpath("//li[3]//a[1]//span");
    private static final By ADVERTS_ON_PAGE_TEXT_LOCATOR = By.xpath("//div[@class='col-xs-9']");
    private static final String ADVERTS_ON_PAGE_TEXT = "Ваши объявления на сайте";

    public CustomizationAdPage openCustomization() {
        waitForElementVisibility(POST_ADVERT_BUTTON_LOCATOR);
        driver.findElement(POST_ADVERT_BUTTON_LOCATOR).click();
        logger.info("open customization");
        return new CustomizationAdPage();
    }

    public DraftPage openDraft() {
        waitForElementVisibility(DRAFT_LOCATOR);
        driver.findElement(DRAFT_LOCATOR).click();
        logger.info("open draft");
        return new DraftPage();
    }

    public boolean isAdvertPosted(){
        return driver.findElement(ADVERTS_ON_PAGE_TEXT_LOCATOR).getText().equals(ADVERTS_ON_PAGE_TEXT);
    }
}
