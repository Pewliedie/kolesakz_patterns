package com.epam.kzta2020.utils;

import com.epam.kzta2020.business_objects.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarBOCreator {

    private static final By CAR_LOCATION_LOCATOR = By.cssSelector("dl:nth-child(1) > dd.value");
    private static final By OFFER_PRICE_LOCATOR = By.cssSelector("div.offer__price");
    private static final By MARK_LOCATOR = By.cssSelector("h1.offer__title > span:nth-child(1)");
    private static final By MODEL_LOCATOR = By.cssSelector("h1.offer__title > span:nth-child(2)");

    public static Car createCar(WebDriver driver) {
        Car car = new Car();
        car.setCity(driver.findElement((CAR_LOCATION_LOCATOR)).getText());
        car.setPrice(driver.findElement(OFFER_PRICE_LOCATOR).getText());
        car.setMark(driver.findElement(MARK_LOCATOR).getText());
        car.setModel(driver.findElement(MODEL_LOCATOR).getText());
        return car;
    }
}
