package com.epam.cdp.kzta2020.webdriver_factory;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {

    public abstract WebDriver webDriverFactory(WebDriver driver, String version, String platform, MutableCapabilities sauceOptions, String url);
}
