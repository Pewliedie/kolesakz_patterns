package com.epam.cdp.kzta2020.driver.wd_factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaDriverManager extends Factory {
    @Override
    public WebDriver getLocalDriver() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        return driver;
    }
}
