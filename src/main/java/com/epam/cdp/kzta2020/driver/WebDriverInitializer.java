package com.epam.cdp.kzta2020.driver;

import com.epam.cdp.kzta2020.common.config.Configuration;
import com.epam.cdp.kzta2020.driver.wd_factory.DriverManager;
import com.epam.cdp.kzta2020.driver.wd_factory.DriverManagerFactory;
import com.epam.cdp.kzta2020.driver.wd_factory.DriverType;
import com.epam.cdp.kzta2020.utils.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class WebDriverInitializer {
    private DriverManager driverManager;
    protected WebDriver driver;

    @BeforeTest(groups = {"UiTest"})
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod(groups = {"UiTest"})
    public WebDriver beforeMethod() {
        driver = driverManager.getDriver();
        ConfigUtil.getConfiguration();
        driver = new WebDriverDecorator(driver);
        driver.manage().timeouts().pageLoadTimeout(Configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Configuration.getBaseUrl());
        return driver;
    }

    @AfterMethod(groups = {"UiTest"})
    public void afterMethod() {
        driverManager.quitDriver();
    }
}
