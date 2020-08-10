package com.epam.cdp.kzta2020.driver.webdriver_factory;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverCreator extends WebDriverCreator {

    @Override
    public WebDriver webDriverFactory(WebDriver driver,String version, String platform, MutableCapabilities sauceOptions, String url) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("w3c", true);
        chromeOptions.setCapability("platformName", platform);
        chromeOptions.setCapability("browserVersion", version);
        chromeOptions.setCapability("sauce:options", sauceOptions);
        try {
            driver = new RemoteWebDriver(new URL(url), chromeOptions);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
