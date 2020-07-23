package factoryPattertn;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageFactory {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        wait = new WebDriverWait(driver,15);
    }

    protected WebDriver getDriver() {
        return this.driver;
    }
}
