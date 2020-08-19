package com.epam.cdp.kzta2020.driver;

import com.epam.cdp.kzta2020.common.config.Configuration;
import com.epam.cdp.kzta2020.driver.wd_factory.DriverManagerFactory;
import com.epam.cdp.kzta2020.driver.wd_factory.DriverType;
import com.epam.cdp.kzta2020.driver.wd_factory.WDFactory;
import com.epam.cdp.kzta2020.utils.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class WebDriverInitializer {
    private static WDFactory driverManager;
    private static WebDriver driver;


    private WebDriverInitializer() {
    }

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    public static WebDriver setUpDriver() {
        if (driver != null) {
            return driver;
        }
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        ConfigUtil.getConfiguration();
        driver = new WebDriverDecorator(driverManager.factoryMethod());
        driver.manage().timeouts().pageLoadTimeout(Configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Configuration.getBaseUrl());
        return driver;
    }

    @AfterMethod(groups = {"UiTest"})
    public static void kill() {
        driver.quit();
        driver = null;
    }
}
