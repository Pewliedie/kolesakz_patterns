package uiTest;

import factoryPattertn.advancedSearchPages.BasePage;
import factoryPattertn.advancedSearchPages.SearchResultPage;
import factoryPattertn.searchWithPhotoPages.FoundResultPage;
import factoryPattertn.searchWithPhotoPages.HomePageSearch;
import org.testng.annotations.*;
import pageObjectPattern.publishAdvertPages.ChoosePostTypePage;
import pageObjectPattern.publishAdvertPages.HomePage;
import pageObjectPattern.publishAdvertPages.LoggedAccountPage;
import pageObjectPattern.publishAdvertPages.LoginPage;
import resources.ConfigProp;
import utils.WebdriverSetUp;

import static resources.ConfigProp.*;

public class KolesaTest extends WebdriverSetUp {

    @Test(groups = {"UiTest"})
    public void PublishAdvertTest() {
        LoginPage loginPage = new HomePage(driver).openLogInPage();
        loginPage.fillNumberInput(ConfigProp.getProperty("phonenumber"))
                .clickLoginButton().fillPasswordInput(ConfigProp.getProperty("password")).clickLoginButton();
        LoggedAccountPage loggedPage = new LoggedAccountPage(driver)
                .openCustomization().configureCategory().configureMark().configureModel().configureYearModel()
                .configureEngineType().configureModification().fillPrice(getProperty("pricePublishAdvert"))
                .configureCity().fillEmail(getProperty("email"))
                .moveToHomePage().openMyAdverts();

        loggedPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();
        new ChoosePostTypePage(driver).chooseFreeAdvert().isAdvertSent();
        new HomePage(driver).openMyAdverts();
        loggedPage.isAdvertPresent().logOff();
    }

    @Test(groups = {"UiTest"})
    public void SearchWithPhoto() {
        HomePageSearch pageSearch = new HomePageSearch(driver);
        pageSearch.checkPage(getProperty("homepage"));
        pageSearch.openAutoSection().chooseCity().fillYearModel(getProperty("yearOfModel"))
                .fillPrice(getProperty("priceSearchWithPhoto")).configureMark().withPhoto().
                clickSearchButton().openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage(driver).switchTab();
        pageSearch.checkPage(getProperty("urlResultPageSearchWithPhoto"));
        foundResultPage.dismissHint().checkPicture();

    }

    @Test(groups = {"UiTest"})
    public void AdvancedSearch() {

        BasePage basePage = new BasePage(driver);
        basePage.checkPage(getProperty("homepage"));

        basePage.openAutoSection().chooseCity().
                fillPrice(getProperty("priceAdvancedSearch")).openAdvancedSearch().configureCountry(getProperty("country"))
                .configureVehicleStatus(getProperty("carStatus")).configureBodyType(getProperty("bodyType"))
                .configureEngineType(getProperty("engineType")).configureLocationWheel(getProperty("locationOfWheel"))
                .configureDriveUnit(getProperty("driveUnit")).configureEngineVolume(getProperty("volumeEngineFrom"), getProperty("volumeEngineTo"))
                .clickSearchButton().openFoundResult();

        SearchResultPage searchResultPage = (SearchResultPage) new SearchResultPage(driver).switchTab();
        searchResultPage.checkPage(getProperty("urlResultPageAdvanced"));
        searchResultPage.dismissHint();
        searchResultPage.assertResults();

    }
}
