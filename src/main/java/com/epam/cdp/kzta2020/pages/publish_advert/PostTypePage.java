package com.epam.cdp.kzta2020.pages.publish_advert;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostTypePage extends AbstractPage {

    private static final By PUBLISH_FREE_ADVERT_LOCATOR = By.xpath("//div[contains(text(),'Подать без продвижения')]");
    private static final By AD_SENT_TO_MODERATOR_TEXT_LOCATOR = By.xpath("//h1");

    private static final String AD_SENT_TO_MODERATOR_TEXT = "Объявление отправлено на проверку!";

    public PostTypePage chooseFreeAdvert() {
        waitForElementVisibility(PUBLISH_FREE_ADVERT_LOCATOR);
        driver.findElement(PUBLISH_FREE_ADVERT_LOCATOR).click();
        return this;
    }

    public boolean isAdSent() {
        return driver.findElement(AD_SENT_TO_MODERATOR_TEXT_LOCATOR).getText().equals(AD_SENT_TO_MODERATOR_TEXT);
    }

}
