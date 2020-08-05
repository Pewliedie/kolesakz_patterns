package com.epam.cdp.kzta2020.ui_tests;

import com.epam.cdp.kzta2020.config.ConfigReader;
import com.epam.cdp.kzta2020.config.Configuration;
import com.epam.cdp.kzta2020.domain.KolesaAdvancedSearchData;
import com.epam.cdp.kzta2020.domain.KolesaDataFactory;
import com.epam.cdp.kzta2020.domain.KolesaPostAdData;
import com.epam.cdp.kzta2020.domain.KolesaSearchWithPhotoData;
import com.epam.cdp.kzta2020.pages.publish_advert.AccountPage;
import com.epam.cdp.kzta2020.pages.publish_advert.HomePage;
import com.epam.cdp.kzta2020.pages.publish_advert.PostTypePage;
import com.epam.cdp.kzta2020.pages.search_with_photo.FoundResultPage;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Kolesa {

    private WebDriver driver;
    private final Configuration configuration = ConfigReader.getConfiguration();


    @Parameters({"browser", "version", "platform", "screenResolution"})
    @BeforeMethod(groups = {"UiTest"}, alwaysRun = true)
    public void setUp(String browser, String version, String platform, String screenResolution) {

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", configuration.getSauceLabLogin());
        sauceOptions.setCapability("accessKey", configuration.getSauceLabAccessKey());
        sauceOptions.setCapability("screenResolution", screenResolution);

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("w3c", true);
                chromeOptions.setCapability("platformName", platform);
                chromeOptions.setCapability("browserVersion", version);
                chromeOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(configuration.getSauceLabUrl()), chromeOptions);
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("platformName", platform);
                firefoxOptions.setCapability("browserVersion", version);
                firefoxOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(configuration.getSauceLabUrl()), firefoxOptions);
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("platformName", platform);
                edgeOptions.setCapability("browserVersion", version);
                edgeOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(configuration.getSauceLabUrl()), edgeOptions);
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }
        driver.get(configuration.getBaseUrl());
        driver.manage().timeouts().pageLoadTimeout(configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
    }


    @Test(groups = {"UiTest"})
    public void publishAdvertTest() {
        KolesaPostAdData kolesaPostAdData = KolesaDataFactory.getPublishAdTermData();
        SoftAssert softAssert = new SoftAssert();

        new HomePage(driver).openLogInPage().login(configuration.getPhoneNumber(), configuration.getPassword());
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openCustomization().customizeAdvert(kolesaPostAdData).returnToHomePage().openAccountPage();
        accountPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();

        PostTypePage postTypePage = new PostTypePage(driver).chooseFreeAdvert();
        softAssert.assertTrue(postTypePage.isAdSent(), "Advert is not posted");
        new HomePage(driver).openAccountPage();
        softAssert.assertTrue(accountPage.isAdvertPosted(), "Advert is not posted");
        softAssert.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void searchWithPhoto() {
        KolesaSearchWithPhotoData kolesaSearchWithPhotoData = KolesaDataFactory.getSearchWithPhotoCarData();
        com.epam.cdp.kzta2020.pages.search_with_photo.HomePage pageSearch = new com.epam.cdp.kzta2020.pages.search_with_photo.HomePage(driver);
        pageSearch.openAutoSection();
        pageSearch.configureSearch(kolesaSearchWithPhotoData).enablePhotoCheckbox()
                .showResult();
        pageSearch.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage(driver).switchTab();
        foundResultPage.dismissHint();
        Assert.assertTrue(new FoundResultPage(driver).isImageDisplayed(), "picture is not displayed");
    }

    @Test(groups = {"UiTest"})
    public void advancedSearch() {
        KolesaAdvancedSearchData kolesaTestTerm = KolesaDataFactory.getAdvancedSearchData();
        SoftAssert softAssert2 = new SoftAssert();
        com.epam.cdp.kzta2020.pages.advanced_search.HomePage homePage = new com.epam.cdp.kzta2020.pages.advanced_search.HomePage(driver);
        homePage.openAutoSection();
        homePage.configureAdvancedSearch(kolesaTestTerm).showResult();
        homePage.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage(driver).switchTab().dismissHint();
        softAssert2.assertTrue(foundResultPage.isBodyTypeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isDriveUnitCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isEngineVolumeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isLocationOfWheelCorrect(), "parameter does not match");
        softAssert2.assertAll();
    }

    @AfterMethod(groups = {"UiTest"})
    public void kill() {
        driver.quit();
    }
}
