package com.epam.cdp.kzta2020.driver.wd_factory;

import org.openqa.selenium.WebDriver;

public abstract class WDFactory {

    protected WebDriver driver;

    public abstract WebDriver factoryMethod();
}
