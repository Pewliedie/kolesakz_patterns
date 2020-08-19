package com.epam.cdp.kzta2020.utils;

import com.epam.cdp.kzta2020.common.config.Configuration;

import static com.epam.cdp.kzta2020.common.config.ConfigReader.getProperty;

public class ConfigUtil {
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String PASSWORD = "password";
    private static final String PAGE_LOAD_TIMEOUT = "pageLoadTimeOut";
    private static final String WAIT_FOR_ELEMENT_TIMEOUT_SECOND = "waitForElementTimeoutSecond";
    private static final String BASE_URL = "baseUrl";

    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setPhoneNumber(getProperty(PHONE_NUMBER));
        configuration.setPassword(getProperty(PASSWORD));
        configuration.setPageLoadTimeOut(Long.valueOf(getProperty(PAGE_LOAD_TIMEOUT)));
        configuration.setWaitForElementTimeoutSecond(Long.valueOf(getProperty(WAIT_FOR_ELEMENT_TIMEOUT_SECOND)));
        configuration.setBaseUrl(getProperty(BASE_URL));
        return configuration;
    }
}