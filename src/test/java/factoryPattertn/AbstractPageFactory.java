package factoryPattertn;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public abstract class AbstractPageFactory {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected SoftAssert softAssertion = new SoftAssert();

    public AbstractPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        wait = new WebDriverWait(driver,15);
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    public WebElement parameter(String str){
        return driver.findElement(By.xpath(String.format("//li[contains(.,'%s')]", str)));
    }


    //bonus task
    public void checkPage(String url) {
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
}
