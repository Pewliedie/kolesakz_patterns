package com.epam.cdp.kzta2020.ui_tests;

import com.epam.cdp.kzta2020.config.ConfigReader;
import com.epam.cdp.kzta2020.config.Configuration;
import com.epam.cdp.kzta2020.pages.move_to_trash_yandex.AccountPage;
import com.epam.cdp.kzta2020.pages.move_to_trash_yandex.LoginPage;
import com.epam.cdp.kzta2020.pages.move_to_trash_yandex.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Yandex {
    private WebDriver driver;
    private final Configuration configuration = ConfigReader.getConfiguration();

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(configuration.getYandexBaseUrl());
    }

    @Test
    public void dragAndDrop() {
        new MainPage(driver).login();
        new LoginPage(driver).login(configuration.getLoginYandex(),configuration.getPasswordYandex());
        AccountPage accountPage = new AccountPage(driver).moveToTrash().openTrash();
        Assert.assertTrue(accountPage.isElementInTrash());
    }

    @AfterMethod
    public void kill() {
        driver.quit();
    }
}
