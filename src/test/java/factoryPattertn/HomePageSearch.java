package factoryPattertn;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageSearch extends AbstractPage{

    @FindBy(xpath = "//div[@class='menu-container container']//li[1]")
    WebElement auto;

    public HomePageSearch(WebDriver driver) {
        super(driver);
    }


    public HomePageSearch open() {
        getDriver().get("https://kolesa.kz/");
        return this;
    }

    public HomePageSearch configureSearch(){
        auto.click();
        wait.until(ExpectedConditions.elementToBeClickable(auto));
        return new HomePageSearch(getDriver());
    }

    public WebElement element(){
        return auto;
    }
}
