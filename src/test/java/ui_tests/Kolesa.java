package ui_tests;

import com.epam.kzta2020.common.config.ConfigReader;
import com.epam.kzta2020.common.config.Configuration;
import com.epam.kzta2020.domain.AdvancedSearchData;
import com.epam.kzta2020.domain.DataFactory;
import com.epam.kzta2020.domain.PostAdData;
import com.epam.kzta2020.pages.publish_advert.AccountPage;
import com.epam.kzta2020.pages.publish_advert.PostTypePage;
import com.epam.kzta2020.pages.search.advanced_search.FoundResultPage;
import com.epam.kzta2020.pages.search.advanced_search.HomePage;
import com.epam.kzta2020.utils.CarBOCreator;
import com.epam.kzta2020.utils.ScreenShoter;
import com.epam.kzta2020.utils.UserCreator;
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
        PostAdData kolesaPostAdData = DataFactory.getPublishAdTermData();
        SoftAssert softAssert = new SoftAssert();
        new com.epam.kzta2020.pages.publish_advert.HomePage(driver).openLogInPage().signIn(UserCreator.getUser());
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openCustomization().customizeAdvert(kolesaPostAdData).returnToHomePage().openAccountPage();
        accountPage.openDraft().editAdvert().postAdvertFromCustomization().chooseType();

        PostTypePage postTypePage = new PostTypePage(driver).chooseFreeAdvert();
        softAssert.assertTrue(postTypePage.isAdSent(), "Advert is not posted");
        new com.epam.kzta2020.pages.publish_advert.HomePage(driver).openAccountPage();
        softAssert.assertTrue(accountPage.isAdvertPosted(), "Advert is not posted");
        softAssert.assertAll();
    }

    @Test(groups = {"UiTest"})
    public void advancedSearch() {
        SoftAssert softAssert2 = new SoftAssert();
        AdvancedSearchData data = DataFactory.getAdvancedSearchData();
        HomePage homePage = new HomePage(driver);
        homePage.openAutoSection();
        homePage.configureAdvancedSearch(data).showResult();
        homePage.openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage(driver).switchTab().dismissHint();
        CarBOCreator.createCar(driver);
        softAssert2.assertTrue(foundResultPage.isBodyTypeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isDriveUnitCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isEngineVolumeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isLocationOfWheelCorrect(), "parameter does not match");
        ScreenShoter.takeScreenShoot(driver);
        softAssert2.assertAll();
    }

    @AfterMethod(groups = {"UiTest"})
    public void kill() {
        driver.quit();
    }
}
