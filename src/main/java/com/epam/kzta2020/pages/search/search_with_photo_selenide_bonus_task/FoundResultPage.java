package com.epam.kzta2020.pages.search.search_with_photo_selenide_bonus_task;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class FoundResultPage{

    private static final By DISMISS_HINT_BUTTON_LOCATOR = By.cssSelector("button.kl-button.kl-button.js__tutorial-close");
    private static final By IMAGE_LOCATOR = By.xpath("//button[@class='gallery__main js__gallery-main']//picture//img");

    public FoundResultPage switchTab() {
        switchTo().window(1);
        return this;
    }

    public FoundResultPage dismissHint() {
        $(DISMISS_HINT_BUTTON_LOCATOR).shouldBe(Condition.enabled).click();
        return this;
    }

    public boolean isImageDisplayed(){
        return $(IMAGE_LOCATOR).isDisplayed();
    }
}
