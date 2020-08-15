package com.epam.cdp.kzta2020.common.config;

import com.epam.cdp.kzta2020.common.exceptions.ConfigurationException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String PASSWORD = "password";
    private static final String PAGE_LOAD_TIMEOUT = "pageLoadTimeOut";
    private static final String WAIT_FOR_ELEMENT_TIMEOUT_SECOND = "waitForElementTimeoutSecond";
    private static final String BASE_URL = "baseUrl";

    private static final Properties PROPERTIES = new Properties();

    private ConfigReader() {
    }

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            throw new ConfigurationException(e.getStackTrace());
        }
    }

    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setPhoneNumber(ConfigReader.getProperty(PHONE_NUMBER));
        configuration.setPassword(ConfigReader.getProperty(PASSWORD));
        configuration.setPageLoadTimeOut(Long.valueOf(ConfigReader.getProperty(PAGE_LOAD_TIMEOUT)));
        configuration.setWaitForElementTimeoutSecond(Long.valueOf(ConfigReader.getProperty(WAIT_FOR_ELEMENT_TIMEOUT_SECOND)));
        configuration.setBaseUrl(ConfigReader.getProperty(BASE_URL));
        return configuration;
    }

    private static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}

