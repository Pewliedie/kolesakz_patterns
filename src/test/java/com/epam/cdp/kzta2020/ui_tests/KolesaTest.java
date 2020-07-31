package com.epam.cdp.kzta2020.ui_tests;

import com.epam.cdp.kzta2020.config.Configuration;
import com.epam.cdp.kzta2020.domain.CarSearchTerm;
import com.epam.cdp.kzta2020.domain.CarSearchTermFactory;
import com.epam.cdp.kzta2020.pages.advanced_search_pages.HomePage;
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


public class KolesaTest extends WebDriverSetUp {

    @Test(groups = {"UiTest"})
    public void publishAdvertTest() {
        CarSearchTerm carSearchTerm = CarSearchTermFactory.getPublishAdTerm();
        LoginPage loginPage = new com.epam.cdp.kzta2020.pages.publish_advert_pages.HomePage().openLogInPage();
        loginPage.fillNumberInput(Configuration.getPhoneNumber())
                .clickLoginButton().fillPasswordInput(Configuration.getPassword()).clickLoginButton();
        LoggedAccountPage loggedPage = new LoggedAccountPage()
                .openCustomization().configureCategory().configureMark().configureModel().configureYearModel()
                .configureEngineType().configureModification().fillPrice(carSearchTerm.getPrice())
                .configureCity().fillEmail(Configuration.getEmail())
                .moveToHomePage().openMyAdverts();

        loggedPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();
        new ChoosePostTypePage().chooseFreeAdvert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Объявление отправлено на проверку!", "Advert is not posted");
        new com.epam.cdp.kzta2020.pages.publish_advert_pages.HomePage().openMyAdverts();
        softAssert.assertEquals(driver.findElement(
                By.xpath("//div[@class='col-xs-9']")).getText(), "Ваши объявления на сайте", "Advert is not posted");
        loggedPage.logOff();
        softAssert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Личный кабинет')]"))
                .getText(), "Личный кабинет", "Not logged out");
        softAssert.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void searchWithPhoto() {
        CarSearchTerm carSearchTerm = CarSearchTermFactory.getSearchWithPhotoCarTerm();
        HomePageSearch pageSearch = new HomePageSearch();
        pageSearch.openAutoSection();
        pageSearch.chooseCity().fillPrice(carSearchTerm.getPrice());
        pageSearch.fillYearModel(carSearchTerm.getModelYear())
                .configureMark().withPhoto().clickSearchButton();
        pageSearch.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab();
        foundResultPage.dismissHint();
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='gallery__main js__gallery-main']//picture//img"))
                .isDisplayed(),"picture is not presented");

    }

    @Test(groups = {"UiTest"})
    public void advancedSearch() {
        CarSearchTerm carSearchTerm = CarSearchTermFactory.getAdvancedSearchCarTerm();
        HomePage homePage = new HomePage();
        homePage.openAutoSection();
        homePage.chooseCity().fillPrice(carSearchTerm.getPrice());
        homePage.openAdvancedSearch().configureCountry(carSearchTerm.getCountry())
                .configureVehicleStatus(carSearchTerm.getCarStatus()).configureBodyType(carSearchTerm.getBodyType())
                .configureEngineType(carSearchTerm.getEngineType()).configureLocationWheel(carSearchTerm.getLocationOfWheel())
                .configureDriveUnit(carSearchTerm.getDriveUnit()).configureEngineVolume(carSearchTerm.getEngineVolumeFrom()
                , carSearchTerm.getEngineVolumeTo())
                .clickSearchButton();
        homePage.openFoundResult();

        new FoundResultPage().switchTab().dismissHint();

        SoftAssert softAssert2 = new SoftAssert();
        softAssert2.assertEquals(driver.findElement(By.cssSelector("dl:nth-child(2) > dd.value")).getText(), carSearchTerm.getBodyType(), "parameter does not match");
        softAssert2.assertEquals(driver.findElement(By.cssSelector("dl:nth-child(3) > dd.value")).getText(), carSearchTerm.getEngineVolumeAndType(), "parameter does not match");
        softAssert2.assertEquals(driver.findElement(By.cssSelector("dl:nth-child(5) > dd.value")).getText(), carSearchTerm.getLocationOfWheel(), "parameter does not match");
        softAssert2.assertEquals(driver.findElement(By.cssSelector("dl:nth-child(7) > dd.value")).getText(), carSearchTerm.getDriveUnit(), "parameter does not match");
        softAssert2.assertAll();
    }

    @AfterMethod
    public void close(){
        WebDriverSetUp.kill();
    }
}
