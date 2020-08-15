package ui_tests;

import com.epam.cdp.kzta2020.business_objects.KolesakzUser;
import com.epam.cdp.kzta2020.domain.KolesaAdvancedSearchData;
import com.epam.cdp.kzta2020.domain.KolesaDataFactory;
import com.epam.cdp.kzta2020.domain.KolesaPostAdData;
import com.epam.cdp.kzta2020.domain.KolesaSearchWithPhotoData;
import com.epam.cdp.kzta2020.driver.WebDriverInitializer;
import com.epam.cdp.kzta2020.pages.publish_advert.AccountPage;
import com.epam.cdp.kzta2020.pages.publish_advert.HomePage;
import com.epam.cdp.kzta2020.pages.publish_advert.PostTypePage;
import com.epam.cdp.kzta2020.pages.search.advanced_search.FoundResultPage;
import com.epam.cdp.kzta2020.utils.ScreenShoter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Kolesa {

    @Test(groups = {"UiTest"})
    public void publishAdvertTest() {
        KolesaPostAdData kolesaPostAdData = KolesaDataFactory.getPublishAdTermData();
        SoftAssert softAssert = new SoftAssert();
        new HomePage().openLogInPage().login(new KolesakzUser());
        ScreenShoter.takeScreenShot();
        AccountPage accountPage = new AccountPage();
        accountPage.openCustomization().customizeAdvert(kolesaPostAdData).returnToHomePage().openAccountPage();
        accountPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();

        PostTypePage postTypePage = new PostTypePage().chooseFreeAdvert();
        softAssert.assertTrue(postTypePage.isAdSent(), "Advert is not posted");
        new HomePage().openAccountPage();
        ScreenShoter.takeScreenShot();
        softAssert.assertTrue(accountPage.isAdvertPosted(), "Advert is not posted");
        ScreenShoter.takeScreenShot();
        softAssert.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void advancedSearch() {
        KolesaAdvancedSearchData kolesaTestTerm = KolesaDataFactory.getAdvancedSearchData();
        SoftAssert softAssert2 = new SoftAssert();
        com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage homePage = new com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage();
        ScreenShoter.takeScreenShot();
        homePage.openAutoSection();
        homePage.configureAdvancedSearch(kolesaTestTerm).showResult();
        ScreenShoter.takeScreenShot();
        homePage.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab().dismissHint();
        softAssert2.assertTrue(foundResultPage.isBodyTypeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isDriveUnitCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isEngineVolumeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isLocationOfWheelCorrect(), "parameter does not match");
        ScreenShoter.takeScreenShot();
        softAssert2.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void searchWithPhoto() {
        KolesaSearchWithPhotoData kolesaSearchWithPhotoData = KolesaDataFactory.getSearchWithPhotoCarData();
        com.epam.cdp.kzta2020.pages.search.search_with_photo.HomePage homePage = new com.epam.cdp.kzta2020.pages.search.search_with_photo.HomePage();
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
        WebDriverInitializer.kill();
    }
}
