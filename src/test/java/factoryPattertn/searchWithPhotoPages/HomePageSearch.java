package factoryPattertn.searchWithPhotoPages;

import factoryPattertn.AbstractPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageSearch extends AbstractPageFactory {

    @FindBy(xpath = "//div[@class='menu-container container']//li[1]")
    WebElement autoSection;

    @FindBy(xpath = "//li[4]//button")
    WebElement city;

    @FindBy(id = "year[from]")
    WebElement yearInput;

    @FindBy(id = "price[from]")
    WebElement priceInput;

    @FindBy(xpath = "//span[7]//span")
    WebElement additionMarks;

    @FindBy(xpath = "//span[contains(text(),'BMW')]")
    WebElement mark;

    @FindBy(xpath = "//label[@for='_sys-hasphoto-checkbox-0']")
    WebElement checkboxPhoto;

    @FindBy(css = "span.label.js__search-form-submit-value")
    WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(),'BMW X6 M')]")
    WebElement foundResult;

    public HomePageSearch(WebDriver driver) {
        super(driver);
    }

    public HomePageSearch openAutoSection() {
        wait.until(ExpectedConditions.elementToBeClickable(autoSection));
        autoSection.click();
        return this;
    }

    public HomePageSearch chooseCity() {
        wait.until(ExpectedConditions.visibilityOf(city));
        city.click();
        return this;
    }

    public HomePageSearch fillYearModel(String year){
        wait.until(ExpectedConditions.visibilityOf(yearInput));
        yearInput.sendKeys(year);
        return this;
    }

    public HomePageSearch fillPrice(String price) {
        wait.until(ExpectedConditions.visibilityOf(priceInput));
        priceInput.sendKeys(price);
        return this;
    }

    public HomePageSearch configureMark(){
        additionMarks.click();
        mark.click();
        return this;
    }

    public HomePageSearch withPhoto(){
        wait.until(ExpectedConditions.elementToBeClickable(checkboxPhoto));
        checkboxPhoto.click();
        return this;
    }

    public HomePageSearch clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }

    public HomePageSearch openFoundResult(){
        wait.until(ExpectedConditions.visibilityOf(foundResult));
        foundResult.click();
        return this;
    }
}
