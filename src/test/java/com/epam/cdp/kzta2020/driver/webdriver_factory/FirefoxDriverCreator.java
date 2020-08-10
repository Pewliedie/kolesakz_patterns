package com.epam.cdp.kzta2020.driver.webdriver_factory;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverCreator extends WebDriverCreator{

    @Override
    public WebDriver webDriverFactory(WebDriver driver, String version, String platform, MutableCapabilities sauceOptions, String url) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("platformName", platform);
        firefoxOptions.setCapability("browserVersion", version);
        firefoxOptions.setCapability("sauce:options", sauceOptions);
        try {
            driver = new RemoteWebDriver(new URL(url), firefoxOptions);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
