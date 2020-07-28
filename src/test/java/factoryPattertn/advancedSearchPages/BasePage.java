package factoryPattertn.advancedSearchPages;


import factoryPattertn.AbstractPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends AbstractPageFactory {

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

    public BasePage configureCountry(String param){
        wait.until(ExpectedConditions.visibilityOf(countryParameter));
        countryParameter.click();
        parameter(param).click();
        return this;
    }

    public BasePage configureVehicleStatus(String param){
        vehicleStatus.click();
        parameter(param).click();
        return this;
    }

    public BasePage configureBodyType(String param){
        carBodyType.click();
        parameter(param).click();
        return this;
    }

    public BasePage configureEngineType(String param){
        engineType.click();
        parameter(param).click();
        return this;
    }

    public BasePage configureLocationWheel(String param){
        locationOfWheel.click();
        parameter(param).click();
        return this;
    }

    public BasePage configureDriveUnit(String param){
        driveUnit.click();
        parameter(param).click();
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
