package com.epam.cdp.kzta2020.utils;

import com.epam.cdp.kzta2020.config.ConfigReader;
import com.epam.cdp.kzta2020.config.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class WebDriverSetUp {

    protected static WebDriver driver;

    public static WebDriver getDriverInstance() {
        if (driver != null) {
            return driver;
        }
        return driver = setUp();
    }



    @BeforeMethod(groups = {"UiTest"})
    public static WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://kolesa.kz/");
        return driver;
    }


    public static void kill() {
        driver.quit();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
            } finally {
                driver = null;
            }
        }
    }
}
