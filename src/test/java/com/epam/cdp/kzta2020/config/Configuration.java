package com.epam.cdp.kzta2020.config;

public class Configuration {

    private String baseUrl;
    private String phoneNumber;
    private String password;
    private Long pageLoadTimeOut;
    private Long waitForElementTimeoutSecond;
    private String gridHubUrl;
    private String sauceLabLogin;
    private String sauceLabAccessKey;
    private String loginYandex;
    private String passwordYandex;
    private String sauceLabUrl;
    private String yandexBaseUrl;


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

    public String getGridHubUrl() {
        return gridHubUrl;
    }

    public void setGridHubUrl(String gridHubUrl) {
        this.gridHubUrl = gridHubUrl;
    }

    public String getSauceLabLogin() {
        return sauceLabLogin;
    }

    public void setSauceLabLogin(String sauceLabLogin) {
        this.sauceLabLogin = sauceLabLogin;
    }

    public String getSauceLabAccessKey() {
        return sauceLabAccessKey;
    }

    public void setSauceLabAccessKey(String sauceLabAccessKey) {
        this.sauceLabAccessKey = sauceLabAccessKey;
    }

    public String getLoginYandex() {
        return loginYandex;
    }

    public void setLoginYandex(String loginYandex) {
        this.loginYandex = loginYandex;
    }

    public String getPasswordYandex() {
        return passwordYandex;
    }

    public void setPasswordYandex(String passwordYandex) {
        this.passwordYandex = passwordYandex;
    }

    public String getSauceLabUrl() {
        return sauceLabUrl;
    }

    public void setSauceLabUrl(String sauceLabUrl) {
        this.sauceLabUrl = sauceLabUrl;
    }

    public String getYandexBaseUrl() {
        return yandexBaseUrl;
    }

    public void setYandexBaseUrl(String yandexBaseUrl) {
        this.yandexBaseUrl = yandexBaseUrl;
    }
}
