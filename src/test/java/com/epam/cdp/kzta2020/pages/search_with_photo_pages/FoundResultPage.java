package com.epam.cdp.kzta2020.pages.search_with_photo_pages;

import org.openqa.selenium.By;
import com.epam.cdp.kzta2020.pages.AbstractPage;

import java.util.ArrayList;

public class FoundResultPage extends AbstractPage {

    private static final By DISMISS_HINT_BUTTON_LOCATOR = By.cssSelector("button.kl-button.kl-button.js__tutorial-close");


    public FoundResultPage switchTab(){
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return this;
    }

    public FoundResultPage dismissHint(){
        waitForElementEnabled(DISMISS_HINT_BUTTON_LOCATOR);
        driver.findElement(DISMISS_HINT_BUTTON_LOCATOR).click();
        return this;
    }
}
