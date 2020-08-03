package com.epam.cdp.kzta2020.utils;

import com.epam.cdp.kzta2020.config.ConfigReader;
import com.epam.cdp.kzta2020.config.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class WebDriverSetUp {

    private static WebDriver driver;

    static Configuration configuration = ConfigReader.getConfiguration();


    public static WebDriver getDriverInstance() {
        if (driver != null) {
            return driver;
        }
        return driver = setUp();
    }

    @BeforeMethod
    public static WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://kolesa.kz/");
        return driver;
    }


    public static void kill() {
        if (driver != null) {
            driver.quit();
        }
    }
}
