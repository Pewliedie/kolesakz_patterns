package factoryPattertn.advancedSearchPages;


import factoryPattertn.AbstractPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends AbstractPageFactory {
    String COUNTRY = "Англия";
    String CAR_STATUS = "На ходу";
    String BODY_TYPE = "внедорожник";
    String ENGINE_TYPE = "бензин";
    String LOCATION_OF_WHEEL = "слева";
    String DRIVE_UNIT = "полный привод";


    @FindBy(xpath = "//div[@class='menu-container container']//li[1]")
    WebElement autoSection;

    @FindBy(xpath = "//li[1]//button")
    WebElement city;

    @FindBy(id = "price[from]")
    WebElement priceInput;

    @FindBy(css = "button.set-optional span.label")
    WebElement advancedSearch;

    @FindBy(css = "div.element-group.element-group-parameter-mark-country")
    WebElement countryParameter;

    @FindBy(css = "div.element-group.element-group-parameter-auto-emergency")
    WebElement vehicleStatus;

    @FindBy(css = "div.element-group.element-group-parameter-auto-car-body")
    WebElement carBodyType;

    @FindBy(css = "div.element-group.element-group-parameter-auto-fuel")
    WebElement engineType;

    @FindBy(css = "div.element-group.element-group-parameter-auto-sweel")
    WebElement locationOfWheel;

    @FindBy(css = "div.element-group.element-group-parameter-car-dwheel")
    WebElement driveUnit;

    @FindBy(css = "#auto-car-volume\\[from\\]")
    WebElement engineVoulumeFrom;

    @FindBy(css = "#auto-car-volume\\[to\\]")
    WebElement engineVoulumeTo;

    @FindBy(css = "button.primary-button")
    WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(),'Rolls-Royce Cullinan')]")
    WebElement searchResult;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public BasePage openAutoSection(){
        wait.until(ExpectedConditions.elementToBeClickable(autoSection));
        autoSection.click();
        return this;
    }

    public BasePage chooseCity(){
        wait.until(ExpectedConditions.visibilityOf(city));
        city.click();
        return this;
    }

    public BasePage fillPrice(String price){
        wait.until(ExpectedConditions.visibilityOf(priceInput));
        priceInput.sendKeys(price);
        return this;
    }

    public BasePage openAdvancedSearch(){
        wait.until(ExpectedConditions.visibilityOf(advancedSearch));
        advancedSearch.click();
        return this;
    }

    public BasePage configureCountry(){
        wait.until(ExpectedConditions.visibilityOf(countryParameter));
        countryParameter.click();
        parameter(COUNTRY).click();
        return this;
    }

    public BasePage configureVehicleStatus(){
        vehicleStatus.click();
        parameter(CAR_STATUS).click();
        return this;
    }

    public BasePage configureBodyType(){
        carBodyType.click();
        parameter(BODY_TYPE).click();
        return this;
    }

    public BasePage configureEngineType(){
        engineType.click();
        parameter(ENGINE_TYPE).click();
        return this;
    }

    public BasePage configureLocationWheel(){
        locationOfWheel.click();
        parameter(LOCATION_OF_WHEEL).click();
        return this;
    }

    public BasePage configureDriveUnit(){
        driveUnit.click();
        parameter(DRIVE_UNIT).click();
        return this;
    }

    public BasePage configureEngineVolume(String volumeFrom,String volumeTo){
        engineVoulumeFrom.sendKeys(volumeFrom);
        engineVoulumeTo.sendKeys(volumeTo);
        return this;
    }

    public BasePage clickSearchButton(){
        searchButton.click();
        return this;
    }

    public BasePage openFoundResult(){
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        searchResult.click();
        return this;
    }
}
