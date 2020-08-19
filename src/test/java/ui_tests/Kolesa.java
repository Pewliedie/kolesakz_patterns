package ui_tests;

import com.epam.cdp.kzta2020.business_objects.Car;
import com.epam.cdp.kzta2020.domain.DataFactory;
import com.epam.cdp.kzta2020.domain.SearchWithPhotoData;
import com.epam.cdp.kzta2020.driver.WebDriverInitializer;
import com.epam.cdp.kzta2020.pages.publish_advert.AccountPage;
import com.epam.cdp.kzta2020.pages.publish_advert.HomePage;
import com.epam.cdp.kzta2020.pages.publish_advert.PostTypePage;
import com.epam.cdp.kzta2020.pages.search.advanced_search.FoundResultPage;
import com.epam.cdp.kzta2020.utils.CarBOCreator;
import com.epam.cdp.kzta2020.utils.RandomNumberGenerator;
import com.epam.cdp.kzta2020.utils.UserCreator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Kolesa {


    @Test(groups = {"UiTest"})
    public void publishAdvertTest() {
        SoftAssert softAssert = new SoftAssert();
        new HomePage().openLogInPage().signIn(UserCreator.getUser());
        AccountPage accountPage = new AccountPage();
        accountPage.openCustomization().customizeAdvert(DataFactory.getCustomizationData()).returnToHomePage().openAccountPage();
        accountPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();

        PostTypePage postTypePage = new PostTypePage().chooseFreeAdvert();
        softAssert.assertTrue(postTypePage.isAdSent(), "Advert is not posted");
        new HomePage().openAccountPage();
        softAssert.assertTrue(accountPage.isAdvertPosted(), "Advert is not posted");
        softAssert.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void advancedSearch() {
        SoftAssert softAssert2 = new SoftAssert();
        com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage homePage = new com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage();
        homePage.openAutoSection();
        homePage.configureAdvancedSearch(DataFactory.getAdvancedSearchData()).showResult();
        homePage.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab().dismissHint();
        softAssert2.assertTrue(foundResultPage.isBodyTypeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isDriveUnitCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isEngineVolumeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isLocationOfWheelCorrect(), "parameter does not match");
        softAssert2.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void searchWithPhoto() {
        SearchWithPhotoData kolesaSearchWithPhotoData = DataFactory.getSearchWithPhotoCarData();
        com.epam.cdp.kzta2020.pages.search.search_with_photo.HomePage homePage = new com.epam.cdp.kzta2020.pages.search.search_with_photo.HomePage();
        homePage.openAutoSection();
        homePage.configureSearch(kolesaSearchWithPhotoData).enablePhotoCheckbox()
                .showResult();
        homePage.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab();
        foundResultPage.dismissHint();
        Assert.assertTrue(foundResultPage.isImageDisplayed(), "picture is not displayed");
    }

    @Test(groups = {"UiTest"})
    public void findRandomCar() {
        com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage homePage = new com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage();
        SoftAssert softAssert3 = new SoftAssert();
        Car car = CarBOCreator.createCar();
        homePage.openAutoSection();
        homePage.configureRandomSearch(car);
        homePage.showResult();
        homePage.openRandomFoundResult(RandomNumberGenerator.generateNumber());
        FoundResultPage foundResultPage = new FoundResultPage().switchTab().dismissHint();
        softAssert3.assertTrue(foundResultPage.isLocationCorrect(car), "parameter does not match");
        softAssert3.assertTrue(foundResultPage.isPriceCorrect(car), "parameter does not match");
        softAssert3.assertTrue(foundResultPage.isMarkCorrect(car), "parameter does not match");
        softAssert3.assertTrue(foundResultPage.isModelCorrect(car), "parameter does not match");
        softAssert3.assertAll();
    }

    @AfterMethod(groups = {"UiTest"})
    public void close(){
        WebDriverInitializer.kill();
    }
}
