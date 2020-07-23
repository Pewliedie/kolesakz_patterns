package factoryPattertn.advancedSearch;


import factoryPattertn.AbstractPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BasePage extends AbstractPageFactory {

    private static final String PRICE = "110_000_000";
    private static final String VOLUME_FROM = "6.5";
    private static final String VOLUME_TO = "6.7";

    @FindBy(xpath = "//div[@class='menu-container container']//li[1]")
    WebElement auto;

    @FindBy(xpath = "//li[1]//button")
    WebElement city;

    @FindBy(id = "price[from]")
    WebElement priceInput;

    @FindBy(css = "button.set-optional span.label")
    WebElement advancedSearch;

    @FindBy(css = "div.element-group.element-group-parameter-mark-country")
    WebElement countryParameter;

    @FindBy(xpath = "//li[contains(.,'Англия')]")
    WebElement county;

    @FindBy(css = "div.element-group.element-group-parameter-auto-emergency")
    WebElement vehicleCondition;

    @FindBy(xpath = "//li[contains(.,'На ходу')]")
    WebElement condition;

    @FindBy(css = "div.element-group.element-group-parameter-auto-car-body")
    WebElement carBodyType;

    @FindBy(xpath = "//li[contains(.,'седан')]")
    WebElement bodyType;

    @FindBy(css = "div.element-group.element-group-parameter-auto-fuel")
    WebElement engineType;

    @FindBy(xpath = "//li[contains(.,'бензин')]")
    WebElement type;

    @FindBy(css = "div.element-group.element-group-parameter-auto-sweel")
    WebElement locationOfTheSteeringWheel;

    @FindBy(xpath = "//li[contains(.,'слева')]")
    WebElement location;

    @FindBy(css = "div.element-group.element-group-parameter-car-dwheel")
    WebElement driveUnit;

    @FindBy(xpath = "//li[contains(.,'полный привод')]")
    WebElement unit;

    @FindBy(css = "#auto-car-volume\\[from\\]")
    WebElement engineVoulumeFrom;

    @FindBy(css = "#auto-car-volume\\[to\\]")
    WebElement engineVoulumeTo;

    @FindBy(css = "button.primary-button")
    WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(),'Rolls-Royce Ghost')]")
    WebElement searchResult;


    public BasePage(WebDriver driver) {
        super(driver);
    }

    public BasePage open() {
        getDriver().get("https://kolesa.kz/");
        return this;
    }

    public BasePage configureAdvancedSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(auto));
        auto.click();

        wait.until(ExpectedConditions.visibilityOf(city));
        city.click();

        wait.until(ExpectedConditions.visibilityOf(priceInput));
        priceInput.sendKeys(PRICE);

        wait.until(ExpectedConditions.visibilityOf(advancedSearch));
        advancedSearch.click();

        wait.until(ExpectedConditions.visibilityOf(countryParameter));
        countryParameter.click();
        county.click();

        vehicleCondition.click();
        condition.click();

        carBodyType.click();
        bodyType.click();

        engineType.click();
        type.click();

        locationOfTheSteeringWheel.click();
        location.click();

        driveUnit.click();
        unit.click();

        engineVoulumeFrom.sendKeys(VOLUME_FROM);
        engineVoulumeTo.sendKeys(VOLUME_TO);

        searchButton.click();

        wait.until(ExpectedConditions.visibilityOf(searchResult));
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Rolls-Royce Ghost')]")).isDisplayed());

        searchResult.click();


        return this;
    }

}
