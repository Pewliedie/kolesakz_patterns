package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static resources.ConfigProp.getProperty;

public class WebdriverSetUp {

    protected WebDriver driver;

    @BeforeMethod(groups = {"UiTest"})
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getProperty("homepage"));
    }

    @AfterMethod(groups = {"UiTest"})
    public void kill() {
        driver.quit();
    }
}
