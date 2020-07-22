package factoryPattertn.searchWithPhotoTest;

import factoryPattertn.AbstractPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePageSearch extends AbstractPageFactory {

    private static final String YEAR = "2020";
    private static final String PRICE = "60_000_000";

    @FindBy(xpath = "//div[@class='menu-container container']//li[1]")
    WebElement auto;

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

    public HomePageSearch open() {
        getDriver().get("https://kolesa.kz/");
        return this;
    }

    public HomePageSearch configureSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(auto));
        auto.click();

        wait.until(ExpectedConditions.visibilityOf(city));
        city.click();

        wait.until(ExpectedConditions.visibilityOf(yearInput));
        yearInput.sendKeys(YEAR);

        wait.until(ExpectedConditions.visibilityOf(priceInput));
        priceInput.sendKeys(PRICE);

        checkboxPhoto.click();

        additionMarks.click();

        mark.click();

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='results']//picture")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='results']//picture")).isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(foundResult));
        foundResult.click();

        return this;
    }
}
