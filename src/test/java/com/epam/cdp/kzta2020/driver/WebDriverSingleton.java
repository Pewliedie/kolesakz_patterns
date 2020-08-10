package com.epam.cdp.kzta2020.driver;

import com.epam.cdp.kzta2020.common.config.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    protected static WebDriver driver;

    private WebDriverSingleton() {

    }

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
        driver.manage().timeouts().pageLoadTimeout(Configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://kolesa.kz/");
        return driver;
    }

    @AfterMethod(groups = {"UiTest"})
    public static void kill() {
        driver.quit();
        driver = null;
    }
}
