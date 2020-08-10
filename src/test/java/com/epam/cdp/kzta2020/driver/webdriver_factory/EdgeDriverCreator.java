package com.epam.cdp.kzta2020.driver.webdriver_factory;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeDriverCreator extends WebDriverCreator{
    @Override
    public WebDriver webDriverFactory(WebDriver driver, String version, String platform, MutableCapabilities sauceOptions, String url) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("platformName", platform);
        edgeOptions.setCapability("browserVersion", version);
        edgeOptions.setCapability("sauce:options", sauceOptions);
        try {
            driver = new RemoteWebDriver(new URL(url), edgeOptions);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
