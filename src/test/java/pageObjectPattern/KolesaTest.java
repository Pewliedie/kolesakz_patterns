package pageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KolesaTest {

    private WebDriver driver;
    private static final String NUMBER = "+7005450128";
    private static final String PASSWORD = "qwerty123";
    private static final String PRICE = "10_000_000";
    private static final String EMAIL = "wladyslaw.permyakov@gmail.com";

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "A:\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void PublishAdvertTest() throws InterruptedException {
        SighInPage sighInPage = new HomePage(driver).open().openSignInPage();
        sighInPage.fillNumberInput(NUMBER).clickLoginButton().fillPasswordInput(PASSWORD).clickLoginButton();
        LoggedAccountPage loggedPage = new LoggedAccountPage(driver).postAdvert().customizeAdvert(PRICE, EMAIL).openMyAdverts();
        loggedPage.openDraft().editAdvert().continueCustomization().publishAdvert();
        new ChoosePostTypePage(driver).chooseFreeAdvert();
        new HomePage(driver).openMyAdverts();
        loggedPage.isAdvertPresent().logOff();
    }
}
