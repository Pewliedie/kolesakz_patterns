package com.epam.cdp.kzta2020.driver.webdriver_factory;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public interface WebDriverCreator {
    WebDriver webDriverFactory(WebDriver driver, String version, String platform, MutableCapabilities sauceOptions, String url);
}
