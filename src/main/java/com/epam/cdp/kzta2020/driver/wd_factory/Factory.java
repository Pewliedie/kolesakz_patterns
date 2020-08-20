package com.epam.cdp.kzta2020.driver.wd_factory;

import org.openqa.selenium.WebDriver;

public abstract class Factory {

    protected WebDriver driver;

    public abstract WebDriver getLocalDriver();
}
