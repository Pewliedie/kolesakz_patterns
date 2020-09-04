package com.epam.cdp.kzta2020.driver;

import com.epam.cdp.kzta2020.common.config.Configuration;
import com.epam.cdp.kzta2020.driver.wd_factory.DriverManagerFactory;
import com.epam.cdp.kzta2020.driver.wd_factory.DriverType;
import com.epam.cdp.kzta2020.driver.wd_factory.Factory;
import com.epam.cdp.kzta2020.utils.ConfigUtil;
import com.epam.cdp.kzta2020.utils.ScreenShot;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverInitializer {
    private static Factory driverManager;
    private static WebDriver driver;


    private WebDriverInitializer() {
    }

    public static WebDriver setUpDriver() {
        if (driver != null) {
            return driver;
        }
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        ConfigUtil.getConfiguration();
        driver = new WebDriverDecorator(driverManager.getLocalDriver());
        driver.manage().timeouts().pageLoadTimeout(Configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Configuration.getBaseUrl());
        return driver;
    }

    public static void kill(Scenario scenario) {
        if (scenario.isFailed()) {
//            System.out.println(scenario.getId());
//            System.out.println(scenario.getId().replace(" ", "_").replace(";", "_"));
            ScreenShot.takeScreenShot(driver, scenario.getId().replace(" ", "_").replace(";", "_"));
        }
        driver.quit();
        driver = null;
    }
}
