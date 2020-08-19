package com.epam.cdp.kzta2020.driver.wd_factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.opera.OperaDriver;

public class OperaDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
    }
}
