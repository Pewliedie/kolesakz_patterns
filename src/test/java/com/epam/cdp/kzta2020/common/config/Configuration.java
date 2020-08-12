package com.epam.cdp.kzta2020.common.config;

public class Configuration {

    private static String baseUrl;
    private String phoneNumber;
    private String password;
    private static Long pageLoadTimeOut;
    private Long waitForElementTimeoutSecond;


    public static String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        Configuration.baseUrl = baseUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Long getPageLoadTimeOut() {
        return pageLoadTimeOut;
    }

    public void setPageLoadTimeOut(Long pageLoadTimeOut) {
        Configuration.pageLoadTimeOut = pageLoadTimeOut;
    }

    public Long getWaitForElementTimeoutSecond() {
        return waitForElementTimeoutSecond;
    }

    public void setWaitForElementTimeoutSecond(Long waitForElementTimeoutSecond) {
        this.waitForElementTimeoutSecond = waitForElementTimeoutSecond;
    }
}
