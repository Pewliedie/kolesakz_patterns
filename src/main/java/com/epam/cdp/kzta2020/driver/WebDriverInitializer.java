package com.epam.cdp.kzta2020.driver;

import com.epam.cdp.kzta2020.common.config.Configuration;
import com.epam.cdp.kzta2020.driver.wd_factory.DriverManagerFactory;
import com.epam.cdp.kzta2020.driver.wd_factory.DriverType;
import com.epam.cdp.kzta2020.driver.wd_factory.Factory;
import com.epam.cdp.kzta2020.utils.ConfigUtil;
import com.epam.cdp.kzta2020.utils.ScreenShot;
import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class WebDriverInitializer {
    private static Factory driverManager;
    private static WebDriver driver;
    private static final Logger logger = Logger.getLogger("kolesa_logger");

    private WebDriverInitializer() {
    }

    public static WebDriver setUpDriver() {
        if (driver != null) {
            return driver;
        }
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        ConfigUtil.getConfiguration();
        driver = new WebDriverDecorator(driverManager.getLocalDriver());
        logger.info("driver instantiated successfully");

        driver.manage().timeouts().pageLoadTimeout(Configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Configuration.getBaseUrl());
        logger.info("web application launched");
        return driver;
    }

    public static void kill(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenShot.takeScreenShot(driver, result.getInstanceName(), result.getName());
            logger.info("take screenshot of failed test");
        }
        driver.quit();
        driver = null;
        logger.info("close browser");
    }
}
