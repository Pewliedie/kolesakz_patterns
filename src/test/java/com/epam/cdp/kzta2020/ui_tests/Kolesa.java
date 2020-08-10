package com.epam.cdp.kzta2020.ui_tests;

import com.epam.cdp.kzta2020.business_objects.KolesakzUser;
import com.epam.cdp.kzta2020.domain.KolesaAdvancedSearchData;
import com.epam.cdp.kzta2020.domain.KolesaDataFactory;
import com.epam.cdp.kzta2020.domain.KolesaPostAdData;
import com.epam.cdp.kzta2020.domain.KolesaSearchWithPhotoData;
import com.epam.cdp.kzta2020.driver.WebDriverSingleton;
import com.epam.cdp.kzta2020.pages.publish_advert.AccountPage;
import com.epam.cdp.kzta2020.pages.publish_advert.HomePage;
import com.epam.cdp.kzta2020.pages.publish_advert.PostTypePage;
import com.epam.cdp.kzta2020.pages.search.advanced_search.FoundResultPage;
import com.epam.cdp.kzta2020.utils.ScreenShooter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Kolesa {

//    private WebDriver driver;
//    private final Configuration configuration = ConfigReader.getConfiguration();


//    @BeforeMethod(groups = {"UiTest"})
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(configuration.getPageLoadTimeOut(), TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get(configuration.getBaseUrl());
//    }


    @Test(groups = {"UiTest"})
    public void publishAdvertTest() {
        KolesaPostAdData kolesaPostAdData = KolesaDataFactory.getPublishAdTermData();
        SoftAssert softAssert = new SoftAssert();
        new HomePage().openLogInPage().login(new KolesakzUser());
        ScreenShooter.takeScreenShoot();
        AccountPage accountPage = new AccountPage();
        accountPage.openCustomization().customizeAdvert(kolesaPostAdData).returnToHomePage().openAccountPage();
        accountPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();

        PostTypePage postTypePage = new PostTypePage().chooseFreeAdvert();
        softAssert.assertTrue(postTypePage.isAdSent(), "Advert is not posted");
        new HomePage().openAccountPage();
        ScreenShooter.takeScreenShoot();
        softAssert.assertTrue(accountPage.isAdvertPosted(), "Advert is not posted");
        ScreenShooter.takeScreenShoot();
        softAssert.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void advancedSearch() {
        KolesaAdvancedSearchData kolesaTestTerm = KolesaDataFactory.getAdvancedSearchData();
        SoftAssert softAssert2 = new SoftAssert();
        com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage homePage = new com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage();
        ScreenShooter.takeScreenShoot();
        homePage.openAutoSection();
        homePage.configureAdvancedSearch(kolesaTestTerm).showResult();
        ScreenShooter.takeScreenShoot();
        homePage.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab().dismissHint();
        softAssert2.assertTrue(foundResultPage.isBodyTypeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isDriveUnitCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isEngineVolumeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isLocationOfWheelCorrect(), "parameter does not match");
        ScreenShooter.takeScreenShoot();
        softAssert2.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void searchWithPhoto() {
        KolesaSearchWithPhotoData kolesaSearchWithPhotoData = KolesaDataFactory.getSearchWithPhotoCarData();
        com.epam.cdp.kzta2020.pages.search.search_with_photo_selenide_bonus_task.HomePage homePage = new com.epam.cdp.kzta2020.pages.search.search_with_photo_selenide_bonus_task.HomePage();
        homePage.openAutoSection();
        homePage.configureSearch(kolesaSearchWithPhotoData).enablePhotoCheckbox()
                .showResult();
        homePage.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab();
        foundResultPage.dismissHint();
        Assert.assertTrue(foundResultPage.isImageDisplayed(), "picture is not displayed");
    }

    @AfterMethod(groups = {"UiTest"})
    public void kill() {
        WebDriverSingleton.kill();
    }
}
