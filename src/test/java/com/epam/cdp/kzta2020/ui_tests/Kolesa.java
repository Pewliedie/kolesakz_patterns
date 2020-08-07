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
import com.epam.cdp.kzta2020.webdriver_factory.ChromeDriverCreator;
import com.epam.cdp.kzta2020.webdriver_factory.EdgeDriverCreator;
import com.epam.cdp.kzta2020.webdriver_factory.FirefoxDriverCreator;
import com.epam.cdp.kzta2020.webdriver_factory.WebDriverCreator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
                WebDriverCreator chromeDriverCreator = new ChromeDriverCreator();
                driver = chromeDriverCreator.webDriverFactory(driver, version, platform, sauceOptions, configuration.getSauceLabUrl());
                break;

            case "firefox":
                WebDriverCreator firefoxDriverCreator = new FirefoxDriverCreator();
                driver = firefoxDriverCreator.webDriverFactory(driver, version, platform, sauceOptions, configuration.getSauceLabUrl());
                break;

            case "edge":
                WebDriverCreator edgeDriverCreator = new EdgeDriverCreator();
                driver = edgeDriverCreator.webDriverFactory(driver, version, platform, sauceOptions, configuration.getSauceLabUrl());
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
