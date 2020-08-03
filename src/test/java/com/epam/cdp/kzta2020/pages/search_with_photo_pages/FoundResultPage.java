package com.epam.cdp.kzta2020.pages.search_with_photo_pages;

import com.epam.cdp.kzta2020.domain.KolesaTestTerm;
import com.epam.cdp.kzta2020.domain.KolesaTestTermFactory;
import org.openqa.selenium.By;
import com.epam.cdp.kzta2020.pages.AbstractPage;

import java.util.ArrayList;

public class FoundResultPage extends AbstractPage {

    private static final By DISMISS_HINT_BUTTON_LOCATOR = By.cssSelector("button.kl-button.kl-button.js__tutorial-close");
    private static final By IMAGE_LOCATOR = By.xpath("//button[@class='gallery__main js__gallery-main']//picture//img");
    private static final By BODY_TYPE_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(2) > dd.value");
    private static final By ENGINE_VOLUME_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(3) > dd.value");
    private static final By LOCATION_OF_WHEEL_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(5) > dd.value");
    private static final By DRIVE_UNIT_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(7) > dd.value");

    KolesaTestTerm kolesaTestTerm = KolesaTestTermFactory.getAdvancedSearchCarTerm();

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



    public boolean isImageDisplayed(){
        return driver.findElement(IMAGE_LOCATOR).isDisplayed();
    }

    public boolean isBodyTypeCorrect(){
        return driver.findElement(BODY_TYPE_PARAMETER_LOCATOR).getText().equals(kolesaTestTerm.getBodyType());
    }

    public boolean isEngineVolumeCorrect(){
        return driver.findElement(ENGINE_VOLUME_PARAMETER_LOCATOR).getText().equals(kolesaTestTerm.getEngineVolumeAndType());
    }

    public boolean isLocationOfWheelCorrect(){
        return driver.findElement(LOCATION_OF_WHEEL_PARAMETER_LOCATOR).getText().equals(kolesaTestTerm.getLocationOfWheel());
    }

    public boolean isDriveUnitCorrect(){
        return driver.findElement(DRIVE_UNIT_PARAMETER_LOCATOR).getText().equals(kolesaTestTerm.getDriveUnit());
    }


}
