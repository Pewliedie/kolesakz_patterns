package com.epam.cdp.kzta2020.config;

public class Configuration {

    private String baseUrl;
    private String phoneNumber;
    private String password;
    private String email;
    private Long pageLoadTimeOut;
    private Long waitForElementTimeoutSecond;



    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPageLoadTimeOut() {
        return pageLoadTimeOut;
    }

    public void setPageLoadTimeOut(Long pageLoadTimeOut) {
        this.pageLoadTimeOut = pageLoadTimeOut;
    }

    public Long getWaitForElementTimeoutSecond() {
        return waitForElementTimeoutSecond;
    }

    public void setWaitForElementTimeoutSecond(Long waitForElementTimeoutSecond) {
        this.waitForElementTimeoutSecond = waitForElementTimeoutSecond;
    }
}
