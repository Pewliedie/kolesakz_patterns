package com.epam.cdp.kzta2020.ui_tests;

import com.epam.cdp.kzta2020.config.Configuration;
import com.epam.cdp.kzta2020.domain.KolesaTestTerm;
import com.epam.cdp.kzta2020.domain.KolesaTestTermFactory;
import com.epam.cdp.kzta2020.pages.advanced_search_pages.HomePage;
import com.epam.cdp.kzta2020.pages.publish_advert_pages.MainPage;
import com.epam.cdp.kzta2020.pages.search_with_photo_pages.FoundResultPage;
import com.epam.cdp.kzta2020.pages.search_with_photo_pages.HomePageSearch;
import com.epam.cdp.kzta2020.utils.WebDriverSetUp;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import com.epam.cdp.kzta2020.pages.publish_advert_pages.PostTypePage;
import com.epam.cdp.kzta2020.pages.publish_advert_pages.AccountPage;
import com.epam.cdp.kzta2020.pages.publish_advert_pages.LoginPage;


public class KolesaTest {

    @Test(groups = {"UiTest"})
    public void publishAdvertTest() {
        KolesaTestTerm kolesaTestTerm = KolesaTestTermFactory.getPublishAdTerm();
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage = new MainPage().openLogInPage();
        loginPage.fillNumberInput(Configuration.getPhoneNumber())
                .clickLoginButton().fillPasswordInput(Configuration.getPassword()).clickLoginButton();

        AccountPage accountPage = new AccountPage()
                .openCustomization().configureCategory().configureMark().configureModel()
                .configureYearModel().configureEngineType().configureModification()
                .fillPrice(kolesaTestTerm.getPrice()).configureCity()
                .fillEmail(Configuration.getEmail())
                .moveToHomePage().openAccountPage();
        accountPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();

        PostTypePage postTypePage = new PostTypePage().chooseFreeAdvert();
        softAssert.assertTrue(postTypePage.isAdSent(), "Advert is not posted");
        new MainPage().openAccountPage();
        softAssert.assertTrue(accountPage.isAdvertPosted(), "Advert is not posted");
        accountPage.logOff();
        softAssert.assertTrue(new MainPage().isLoggedOut(), "Not logged out");
        softAssert.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void searchWithPhoto() {
        KolesaTestTerm kolesaTestTerm = KolesaTestTermFactory.getSearchWithPhotoCarTerm();
        HomePageSearch pageSearch = new HomePageSearch();
        pageSearch.openAutoSection();
        pageSearch.chooseCity().fillPrice(kolesaTestTerm.getPrice());
        pageSearch.fillYearModel(kolesaTestTerm.getModelYear())
                .configureMark().withPhoto().clickSearchButton();
        pageSearch.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab();
        foundResultPage.dismissHint();
        Assert.assertTrue(new FoundResultPage().isImageDisplayed(), "picture is not displayed");
    }

    @Test(groups = {"UiTest"})
    public void advancedSearch() {
        KolesaTestTerm kolesaTestTerm = KolesaTestTermFactory.getAdvancedSearchCarTerm();
        SoftAssert softAssert2 = new SoftAssert();

        HomePage homePage = new HomePage();
        homePage.openAutoSection();
        homePage.chooseCity().fillPrice(kolesaTestTerm.getPrice());
        homePage.openAdvancedSearch().configureCountry(kolesaTestTerm.getCountry())
                .configureVehicleStatus(kolesaTestTerm.getCarStatus()).configureBodyType(kolesaTestTerm.getBodyType())
                .configureEngineType(kolesaTestTerm.getEngineType()).configureLocationWheel(kolesaTestTerm.getLocationOfWheel())
                .configureDriveUnit(kolesaTestTerm.getDriveUnit()).configureEngineVolume(kolesaTestTerm.getEngineVolumeFrom()
                , kolesaTestTerm.getEngineVolumeTo())
                .clickSearchButton();
        homePage.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab().dismissHint();

        softAssert2.assertTrue(foundResultPage.isBodyTypeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isDriveUnitCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isEngineVolumeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isLocationOfWheelCorrect(), "parameter does not match");
        softAssert2.assertAll();
    }

    @AfterMethod
    public void close() {
        WebDriverSetUp.kill();
    }
}
