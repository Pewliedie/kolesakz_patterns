package com.epam.cdp.kzta2020.pages.search.advanced_search;

import com.epam.cdp.kzta2020.business_objects.Car;
import com.epam.cdp.kzta2020.domain.AdvancedSearchData;
import com.epam.cdp.kzta2020.domain.DataFactory;
import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Optional;

public class FoundResultPage extends AbstractPage {

    private static final By DISMISS_HINT_BUTTON_LOCATOR = By.cssSelector("button.kl-button.kl-button.js__tutorial-close");
    private static final By BODY_TYPE_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(2) > dd.value");
    private static final By ENGINE_VOLUME_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(3) > dd.value");
    private static final By LOCATION_OF_WHEEL_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(5) > dd.value");
    private static final By DRIVE_UNIT_PARAMETER_LOCATOR = By.cssSelector("dl:nth-child(7) > dd.value");
    private static final By CAR_LOCATION_LOCATOR = By.cssSelector("dl:nth-child(1) > dd.value");
    private static final By OFFER_PRICE_LOCATOR = By.cssSelector("div.offer__price");
    private static final By MARK_LOCATOR = By.cssSelector("h1.offer__title > span:nth-child(1)");
    private static final By MODEL_LOCATOR = By.cssSelector("h1.offer__title > span:nth-child(2)");

    private final AdvancedSearchData kolesaTestTerm = DataFactory.getAdvancedSearchData();

    public FoundResultPage(WebDriver driver) {
        super(driver);
    }

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

    public boolean isBodyTypeCorrect() {
        return Optional.of(driver.findElement(BODY_TYPE_PARAMETER_LOCATOR).getText()).equals(kolesaTestTerm.getBodyType());
    }

    public boolean isEngineVolumeCorrect() {
        return Optional.of(driver.findElement(ENGINE_VOLUME_PARAMETER_LOCATOR).getText()).equals(kolesaTestTerm.getEngineVolumeAndType());
    }

    public boolean isLocationOfWheelCorrect() {
        return Optional.of(driver.findElement(LOCATION_OF_WHEEL_PARAMETER_LOCATOR).getText()).equals(kolesaTestTerm.getLocationOfWheel());
    }

    public boolean isDriveUnitCorrect() {
        return Optional.of(driver.findElement(DRIVE_UNIT_PARAMETER_LOCATOR).getText()).equals(kolesaTestTerm.getDriveUnit());
    }

    public boolean isLocationCorrect(Car car) {
        System.out.println(car.getCity());
        return car.getCity().toString().contains(driver.findElement(CAR_LOCATION_LOCATOR).getText());
    }

    public boolean isPriceCorrect(Car car) {
        System.out.println(car.getPriceFrom());
        return car.getPriceFrom().toString().contains(driver.findElement(OFFER_PRICE_LOCATOR).getText());
    }

    public boolean isMarkCorrect(Car car) {
        System.out.println(car.getMark());
        return Optional.of(driver.findElement(MARK_LOCATOR).getText().toLowerCase()).equals(car.getMark());
    }

    public boolean isModelCorrect(Car car) {
        System.out.println(car.getModel());
        return Optional.of(driver.findElement(MODEL_LOCATOR).getText().toLowerCase()).equals(car.getModel());
    }
}
