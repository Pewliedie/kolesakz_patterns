import factoryPattertn.advancedSearch.BasePage;
import factoryPattertn.advancedSearch.SearchResultPage;
import factoryPattertn.searchWithPhotoTest.FoundResultPage;
import factoryPattertn.searchWithPhotoTest.HomePageSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjectPattern.PublishAdvertTest.ChoosePostTypePage;
import pageObjectPattern.PublishAdvertTest.HomePage;
import pageObjectPattern.PublishAdvertTest.LoggedAccountPage;
import pageObjectPattern.PublishAdvertTest.SighInPage;

import java.util.concurrent.TimeUnit;

public class KolesaTest {

    private WebDriver driver;
    private static final String NUMBER = "+7005450128";
    private static final String PASSWORD = "qwerty123";
    private static final String PRICE = "10_000_000";
    private static final String EMAIL = "wladyslaw.permyakov@gmail.com";

    @BeforeMethod(groups = {"UiTest"})
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "A:\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(groups = {"UiTest"})
    public void PublishAdvertTest() throws InterruptedException {
        SighInPage sighInPage = new HomePage(driver).open().openSignInPage();
        sighInPage.fillNumberInput(NUMBER).clickLoginButton().fillPasswordInput(PASSWORD).clickLoginButton();
        LoggedAccountPage loggedPage = new LoggedAccountPage(driver).postAdvert().customizeAdvert(PRICE, EMAIL).openMyAdverts();
        loggedPage.openDraft().editAdvert().continueCustomization().publishAdvert();
        new ChoosePostTypePage(driver).chooseFreeAdvert();
        new HomePage(driver).openMyAdverts();
        loggedPage.isAdvertPresent().logOff();
    }

    @Test(groups = {"UiTest"})
    public void SearchWithPhoto(){
        new HomePageSearch(driver).open().configureSearch();
        new FoundResultPage(driver).switchTab().dismissHint().checkPicture();
    }

    @Test(groups = {"UiTest"})
    public void AdvancedSearch() {
        new BasePage(driver).open().configureAdvancedSearch();
        SearchResultPage searchResultPage = (SearchResultPage) new SearchResultPage(driver).switchTab().dismissHint();
        new SearchResultPage(driver).assertResults();
    }

    @AfterMethod(groups = {"UiTest"})
    public void kill(){
        driver.quit();
    }
}
