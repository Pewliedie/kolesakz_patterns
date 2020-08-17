package com.epam.cdp.kzta2020.common.config;

import com.epam.cdp.kzta2020.common.exceptions.ConfigurationException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

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

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}

