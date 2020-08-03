package com.epam.cdp.kzta2020.ui_tests;

import com.epam.cdp.kzta2020.config.ConfigReader;
import com.epam.cdp.kzta2020.config.Configuration;
import com.epam.cdp.kzta2020.domain.KolesaAdvancedSearchData;
import com.epam.cdp.kzta2020.domain.KolesaDataFactory;
import com.epam.cdp.kzta2020.domain.KolesaPostAdData;
import com.epam.cdp.kzta2020.domain.KolesaSearchWithPhotoData;
import com.epam.cdp.kzta2020.pages.advanced_search.HomePage;
import com.epam.cdp.kzta2020.pages.publish_advert.AccountPage;
import com.epam.cdp.kzta2020.pages.publish_advert.MainPage;
import com.epam.cdp.kzta2020.pages.publish_advert.PostTypePage;
import com.epam.cdp.kzta2020.pages.search_with_photo.FoundResultPage;
import com.epam.cdp.kzta2020.pages.search_with_photo.HomePageSearch;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Kolesa {

//    private WebDriver driver;
//    private Configuration configuration = ConfigReader.getConfiguration();
//
//    public WebDriver setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get(configuration.getBaseUrl());
//        return driver;
//    }


    @Test(groups = {"UiTest"})
    public void publishAdvertTest() {
        Configuration configuration = ConfigReader.getConfiguration();
        KolesaPostAdData kolesaPostAdData = KolesaDataFactory.getPublishAdTermData();
        SoftAssert softAssert = new SoftAssert();

        new MainPage().openLogInPage().login(configuration.getPhoneNumber(),configuration.getPassword());
        AccountPage accountPage = new AccountPage();
        accountPage.openCustomization().customizeAdvert(kolesaPostAdData).returnToHomePage().openAccountPage();
        accountPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();

        PostTypePage postTypePage = new PostTypePage().chooseFreeAdvert();
        softAssert.assertTrue(postTypePage.isAdSent(), "Advert is not posted");
        new MainPage().openAccountPage();
        softAssert.assertTrue(accountPage.isAdvertPosted(), "Advert is not posted");
        softAssert.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void searchWithPhoto() {
        KolesaSearchWithPhotoData kolesaSearchWithPhotoData = KolesaDataFactory.getSearchWithPhotoCarData();
        HomePageSearch pageSearch = new HomePageSearch();
        pageSearch.openAutoSection();
        pageSearch.configureSearch(kolesaSearchWithPhotoData).enablePhotoCheckbox()
                .showResult();
        pageSearch.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab();
        foundResultPage.dismissHint();
        Assert.assertTrue(new FoundResultPage().isImageDisplayed(), "picture is not displayed");
    }

    @Test(groups = {"UiTest"})
    public void advancedSearch() {
        KolesaAdvancedSearchData kolesaTestTerm = KolesaDataFactory.getAdvancedSearchData();
        SoftAssert softAssert2 = new SoftAssert();

        HomePage homePage = new HomePage();
        homePage.openAutoSection();
        homePage.configureAdvancedSearch(kolesaTestTerm).showResult();
        homePage.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab().dismissHint();

        softAssert2.assertTrue(foundResultPage.isBodyTypeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isDriveUnitCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isEngineVolumeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isLocationOfWheelCorrect(), "parameter does not match");
        softAssert2.assertAll();
    }

//    @AfterMethod
//    public void close() {
//        WebDriverSetUp.kill();
//    }
}
