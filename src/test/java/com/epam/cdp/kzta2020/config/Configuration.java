package com.epam.cdp.kzta2020.config;

public class Configuration {

    private String PHONE_NUMBER = "phonenumber";
    private static String phoneNumber;
    private String PASSWORD = "password";
    private static String password;
    private String EMAIL = "email";
    private static String email;
    private String PAGE_LOAD_TIMEOUT = "pageLoadTimeOut";
    private static Long pageLoadTimeOut;
    private String WAIT_FOR_ELEMENT_TIMEOUT_SECOND = "waitForElementTimeoutSecond";
    private static Long waitForElementTimeoutSecond;

    private static Configuration configuration;


    public Configuration() {
        phoneNumber = ConfigProp.getProperty(PHONE_NUMBER);
        password = ConfigProp.getProperty(PASSWORD);
        email = ConfigProp.getProperty(EMAIL);
        pageLoadTimeOut = Long.valueOf(ConfigProp.getProperty(PAGE_LOAD_TIMEOUT));
        waitForElementTimeoutSecond = Long.valueOf(ConfigProp.getProperty(WAIT_FOR_ELEMENT_TIMEOUT_SECOND));
    }

    static {
        configuration = new Configuration();
    }

    public static Long getPageLoadTimeOut() {
        return pageLoadTimeOut;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getPassword() {
        return password;
    }

    public static String getEmail() {
        return email;
    }

    public static Long getWaitForElementTimeoutSecond() {
        return waitForElementTimeoutSecond;
    }
}
