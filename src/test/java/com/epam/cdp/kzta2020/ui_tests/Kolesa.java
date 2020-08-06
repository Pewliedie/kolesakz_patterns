package com.epam.cdp.kzta2020.ui_tests;

import com.epam.cdp.kzta2020.business_objects.KolesakzUser;
import com.epam.cdp.kzta2020.common.config.ConfigReader;
import com.epam.cdp.kzta2020.common.config.Configuration;
import com.epam.cdp.kzta2020.domain.KolesaAdvancedSearchData;
import com.epam.cdp.kzta2020.domain.KolesaDataFactory;
import com.epam.cdp.kzta2020.domain.KolesaPostAdData;
import com.epam.cdp.kzta2020.pages.publish_advert.AccountPage;
import com.epam.cdp.kzta2020.pages.publish_advert.HomePage;
import com.epam.cdp.kzta2020.pages.publish_advert.PostTypePage;
import com.epam.cdp.kzta2020.pages.search.advanced_search.FoundResultPage;
import com.epam.cdp.kzta2020.utils.ScreenShooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Kolesa {

    private WebDriver driver;
    private final Configuration configuration = ConfigReader.getConfiguration();


    @BeforeMethod(groups = {"UiTest"})
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(configuration.getBaseUrl());
    }


    @Test(groups = {"UiTest"})
    public void publishAdvertTest() {
        KolesaPostAdData kolesaPostAdData = KolesaDataFactory.getPublishAdTermData();
        SoftAssert softAssert = new SoftAssert();
        ScreenShooter.takeScreenShoot();
        new HomePage(driver).openLogInPage().login(new KolesakzUser());
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openCustomization().customizeAdvert(kolesaPostAdData).returnToHomePage().openAccountPage();
        accountPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();

        PostTypePage postTypePage = new PostTypePage(driver).chooseFreeAdvert();
        softAssert.assertTrue(postTypePage.isAdSent(), "Advert is not posted");
        new HomePage(driver).openAccountPage();
        ScreenShooter.takeScreenShoot();
        softAssert.assertTrue(accountPage.isAdvertPosted(), "Advert is not posted");
        ScreenShooter.takeScreenShoot();
        softAssert.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void advancedSearch() {
        KolesaAdvancedSearchData kolesaTestTerm = KolesaDataFactory.getAdvancedSearchData();
        SoftAssert softAssert2 = new SoftAssert();
        com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage homePage = new com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage(driver);
        ScreenShooter.takeScreenShoot();
        homePage.openAutoSection();
        homePage.configureAdvancedSearch(kolesaTestTerm).showResult();
        ScreenShooter.takeScreenShoot();
        homePage.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage(driver).switchTab().dismissHint();
        softAssert2.assertTrue(foundResultPage.isBodyTypeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isDriveUnitCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isEngineVolumeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isLocationOfWheelCorrect(), "parameter does not match");
        ScreenShooter.takeScreenShoot();
        softAssert2.assertAll();
    }

    @AfterMethod(groups = {"UiTest"})
    public void kill() {
        driver.quit();
    }
}
