package com.epam.cdp.kzta2020.pages.search.advanced_search;

import com.epam.cdp.kzta2020.business_objects.Car;
import com.epam.cdp.kzta2020.domain.AdvancedSearchData;
import com.epam.cdp.kzta2020.domain.DataFactory;
import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;
import static com.epam.cdp.kzta2020.utils.PageUtil.getText;

import java.util.ArrayList;
import java.util.Optional;

public class FoundResultPage extends AbstractPage {

    private static final By DISMISS_HINT_BUTTON_LOCATOR = By.cssSelector("button.kl-button.kl-button.js__tutorial-close");
    private static final By BODY_TYPE_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(2) > dd.value");
    private static final By ENGINE_VOLUME_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(3) > dd.value");
    private static final By LOCATION_OF_WHEEL_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(5) > dd.value");
    private static final By DRIVE_UNIT_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(7) > dd.value");
    private static final By IMAGE_LOCATOR = By.xpath("//button[@class='gallery__main js__gallery-main']//picture//img");
    private static final By CAR_LOCATION_LOCATOR = By.cssSelector("dl:nth-child(1) > dd.value");
    private static final By OFFER_PRICE_LOCATOR = By.cssSelector("div.offer__price");
    private static final By MARK_LOCATOR = By.cssSelector("h1.offer__title > span:nth-child(1)");
    private static final By MODEL_LOCATOR = By.cssSelector("h1.offer__title > span:nth-child(2)");

    AdvancedSearchData kolesaTestTerm = DataFactory.getAdvancedSearchData();

    public FoundResultPage switchTab() {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return this;
    }

    public FoundResultPage dismissHint() {
        waitForElementEnabled(DISMISS_HINT_BUTTON_LOCATOR);
        driver.findElement(DISMISS_HINT_BUTTON_LOCATOR).click();
        return this;
    }

    public boolean isImageDisplayed() {
        return driver.findElement(IMAGE_LOCATOR).isDisplayed();
    }

    public boolean isBodyTypeCorrect() {
        return Optional.of(getText(BODY_TYPE_PARAMETER_LOCATOR)).equals(kolesaTestTerm.getBodyType());
    }

    public boolean isEngineVolumeCorrect() {
        return Optional.of(getText(ENGINE_VOLUME_PARAMETER_LOCATOR)).equals(kolesaTestTerm.getEngineVolumeAndType());
    }

    public boolean isLocationOfWheelCorrect() {
        return Optional.of(getText(LOCATION_OF_WHEEL_PARAMETER_LOCATOR)).equals(kolesaTestTerm.getLocationOfWheel());
    }

    public boolean isDriveUnitCorrect() {
        return Optional.of(getText(DRIVE_UNIT_PARAMETER_LOCATOR)).equals(kolesaTestTerm.getDriveUnit());
    }

    public boolean isLocationCorrect(Car car) {
        return car.getCity().toString().contains(getText(CAR_LOCATION_LOCATOR));
    }

    public boolean isPriceCorrect(Car car) {
        return car.getPriceFrom().toString().contains(getText(OFFER_PRICE_LOCATOR));
    }

    public boolean isMarkCorrect(Car car) {
        return Optional.of(getText(MARK_LOCATOR).toLowerCase()).equals(car.getMark());
    }

    public boolean isModelCorrect(Car car) {
        return Optional.of(getText(MODEL_LOCATOR).toLowerCase()).equals(car.getModel());
    }
}