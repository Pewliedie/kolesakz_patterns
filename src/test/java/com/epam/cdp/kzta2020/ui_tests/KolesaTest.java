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
import com.epam.cdp.kzta2020.pages.publish_advert_pages.ChoosePostTypePage;
import com.epam.cdp.kzta2020.pages.publish_advert_pages.LoggedAccountPage;
import com.epam.cdp.kzta2020.pages.publish_advert_pages.LoginPage;



public class KolesaTest{

    @Test(groups = {"UiTest"})
    public void publishAdvertTest() {
        KolesaTestTerm kolesaTestTerm = KolesaTestTermFactory.getPublishAdTerm();
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage = new MainPage().openLogInPage();
        loginPage.fillNumberInput(Configuration.getPhoneNumber())
                .clickLoginButton().fillPasswordInput(Configuration.getPassword()).clickLoginButton();

        LoggedAccountPage loggedPage = new LoggedAccountPage()
                .openCustomization().configureCategory().configureMark().configureModel()
                .configureYearModel().configureEngineType().configureModification()
                .fillPrice(kolesaTestTerm.getPrice()).configureCity()
                .fillEmail(Configuration.getEmail())
                .moveToHomePage().openMyAdverts();
        loggedPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();

        new ChoosePostTypePage().chooseFreeAdvert();
        softAssert.assertEquals(WebDriverSetUp.getDriverInstance().findElement(By.xpath("//h1")).getText(), "Объявление отправлено на проверку!", "Advert is not posted");
        new MainPage().openMyAdverts();
        softAssert.assertEquals(WebDriverSetUp.getDriverInstance().findElement(
                By.xpath("//div[@class='col-xs-9']")).getText(), "Ваши объявления на сайте", "Advert is not posted");
        loggedPage.logOff();
        softAssert.assertEquals(WebDriverSetUp.getDriverInstance().findElement(By.xpath("//span[contains(text(),'Личный кабинет')]"))
                .getText(), "Личный кабинет", "Not logged out");
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
        Assert.assertTrue(WebDriverSetUp.getDriverInstance().findElement(By.xpath("//button[@class='gallery__main js__gallery-main']//picture//img"))
                .isDisplayed(),"picture is not displayed");
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

        new FoundResultPage().switchTab().dismissHint();

        softAssert2.assertEquals(WebDriverSetUp.getDriverInstance().findElement(By.cssSelector("dl:nth-child(2) > dd.value")).getText(), kolesaTestTerm.getBodyType(), "parameter does not match");
        softAssert2.assertEquals(WebDriverSetUp.getDriverInstance().findElement(By.cssSelector("dl:nth-child(3) > dd.value")).getText(), kolesaTestTerm.getEngineVolumeAndType(), "parameter does not match");
        softAssert2.assertEquals(WebDriverSetUp.getDriverInstance().findElement(By.cssSelector("dl:nth-child(5) > dd.value")).getText(), kolesaTestTerm.getLocationOfWheel(), "parameter does not match");
        softAssert2.assertEquals(WebDriverSetUp.getDriverInstance().findElement(By.cssSelector("dl:nth-child(7) > dd.value")).getText(), kolesaTestTerm.getDriveUnit(), "parameter does not match");
        softAssert2.assertAll();
    }

    @AfterMethod
    public void close(){
        WebDriverSetUp.kill();
    }
}
