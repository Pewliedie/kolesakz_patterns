package com.epam.cdp.kzta2020.pages.move_to_trash_yandex;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    private static final By LOGIN_BUTTON = By.linkText("Войти");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(){
        waitForElementEnabled(LOGIN_BUTTON);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
}
