import factoryPattertn.advancedSearch.BasePage;
import factoryPattertn.advancedSearch.SearchResultPage;
import factoryPattertn.searchWithPhotoTest.FoundResultPage;
import factoryPattertn.searchWithPhotoTest.HomePageSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjectPattern.publishAdvert.ChoosePostTypePage;
import pageObjectPattern.publishAdvert.HomePage;
import pageObjectPattern.publishAdvert.LoggedAccountPage;
import pageObjectPattern.publishAdvert.LoginPage;
import resources.ConfigProp;

import static resources.ConfigProp.getProperty;

import java.util.concurrent.TimeUnit;

public class KolesaTest {

    private WebDriver driver;

    @BeforeMethod(groups = {"UiTest"})
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getProperty("homepage"));
    }

    @Test(groups = {"UiTest"})
    public void PublishAdvertTest(){
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
    public void SearchWithPhoto(){
        new HomePageSearch(driver).openAutoSection().chooseCity().fillYearModel(getProperty("yearOfModel"))
                .fillPrice(getProperty("priceSearchWithPhoto")).configureMark().withPhoto().
        clickSearchButton().openFoundResult();
        new FoundResultPage(driver).switchTab().dismissHint().checkPicture();
    }

    @Test(groups = {"UiTest"})
    public void AdvancedSearch() {
        new BasePage(driver).openAutoSection().chooseCity().
                fillPrice(getProperty("priceAdvancedSearch")).openAdvancedSearch().configureCountry()
                .configureVehicleStatus().configureBodyType().configureEngineType().configureLocationWheel()
                .configureDriveUnit().configureEngineVolume(getProperty("volumeEngineFrom"),getProperty("volumeEngineTo"))
                .clickSearchButton().openFoundResult();

        SearchResultPage searchResultPage = (SearchResultPage) new SearchResultPage(driver).switchTab().dismissHint();
        searchResultPage.assertResults();
    }

    @AfterMethod(groups = {"UiTest"})
    public void kill(){
        driver.quit();
    }
}
