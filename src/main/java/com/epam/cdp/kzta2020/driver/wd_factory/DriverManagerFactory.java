package com.epam.cdp.kzta2020.driver.wd_factory;

public class DriverManagerFactory {

    public static WDFactory getManager(DriverType type) {

        WDFactory driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case OPERA:
                driverManager = new OperaDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return driverManager;
    }
}