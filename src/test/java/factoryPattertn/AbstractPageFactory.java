package factoryPattertn;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AbstractPageFactory {
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
}
