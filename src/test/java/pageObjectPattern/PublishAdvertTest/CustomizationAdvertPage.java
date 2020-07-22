package pageObjectPattern.PublishAdvertTest;

import pageObjectPattern.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomizationAdvertPage extends AbstractPage {

    private static final By ADVERT_OPTION_1_LOCATOR = By.xpath("//body//option[1]");
    private static final By ADVERT_OPTION_2_LOCATOR = By.xpath("//div[@id='category-parameter']//option[1]");
    private static final By ADVERT_OPTION_MARK_LOCATOR = By.xpath("//div[contains(text(),'Toyota')]");
    private static final By ADVERT_OPTION_MODEL_LOCATOR = By.xpath("//button[contains(text(),'Camry')]");
    private static final By ADVERT_OPTION_MODEL_YEAR_LOCATOR = By.xpath("//label[contains(text(),'2015')]");
    private static final By ADVERT_OPTION_ENGINE_TYPE_LOCATOR = By.xpath("//div[@class='a-form__input-group']//li[1]//label");
    private static final By ADVERT_OPTION_MODIFICATION_TYPE_LOCATOR = By.xpath("//li[2]//label[1]//div");
    private static final By ADVERT_OPTION_PRICE_INPUT_LOCATOR = By.xpath("//label[@class='ui-input a-form__price']");
    private static final By ADVERT_OPTION_CHOOSE_CITY_LOCATOR = By.xpath("//input[@placeholder='Выберите']");
    private static final By ADVERT_OPTION_CITY_LOCATOR = By.xpath("//ul/li[contains(.,'Караганда')]");
    private static final By ADVERT_OPTION_EMAIL_INPUT_LOCATOR = By.xpath("//label[@class='ui-input a-form__email']");
    private static final By HEADER_LOGO_IMAGE_BUTTON_LOCATOR = By.xpath("//a[@class='header-logo']//img");

    private static final By CONTINUE_CUSTOMIZATION_BUTTON_LOCATOR = By.cssSelector(".ui-button--blue");
    private static final By PUBLISH_ADVERT_BUTTON_LOCATOR = By.cssSelector(".ui-button--shadow");

    public CustomizationAdvertPage(WebDriver driver) {
        super(driver);
    }

    public HomePage customizeAdvert(String price, String email) throws InterruptedException {
        setWaitForElementEnabled(ADVERT_OPTION_1_LOCATOR);
        Thread.sleep(500);
        getDriver().findElement(ADVERT_OPTION_1_LOCATOR).click();

        setWaitForElementVisibility(ADVERT_OPTION_2_LOCATOR);
        getDriver().findElement(ADVERT_OPTION_2_LOCATOR).click();

        setWaitForElementVisibility(ADVERT_OPTION_MARK_LOCATOR);
        getDriver().findElement(ADVERT_OPTION_MARK_LOCATOR).click();

        setWaitForElementVisibility(ADVERT_OPTION_MODEL_LOCATOR);
        getDriver().findElement(ADVERT_OPTION_MODEL_LOCATOR).click();

        setWaitForElementVisibility(ADVERT_OPTION_MODEL_YEAR_LOCATOR);
        getDriver().findElement(ADVERT_OPTION_MODEL_YEAR_LOCATOR).click();

        setWaitForElementVisibility(ADVERT_OPTION_ENGINE_TYPE_LOCATOR);
        getDriver().findElement(ADVERT_OPTION_ENGINE_TYPE_LOCATOR).click();

        setWaitForElementEnabled(ADVERT_OPTION_MODIFICATION_TYPE_LOCATOR);
        getDriver().findElement(ADVERT_OPTION_MODIFICATION_TYPE_LOCATOR).click();

        setWaitForElementVisibility(ADVERT_OPTION_PRICE_INPUT_LOCATOR);
        getDriver().findElement(ADVERT_OPTION_PRICE_INPUT_LOCATOR).sendKeys(price);

        setWaitForElementVisibility(ADVERT_OPTION_CHOOSE_CITY_LOCATOR);
        getDriver().findElement(ADVERT_OPTION_CHOOSE_CITY_LOCATOR).click();

        setWaitForElementVisibility(ADVERT_OPTION_CITY_LOCATOR);
        getDriver().findElement(ADVERT_OPTION_CITY_LOCATOR).click();

        setWaitForElementVisibility(ADVERT_OPTION_EMAIL_INPUT_LOCATOR);
        getDriver().findElement(ADVERT_OPTION_EMAIL_INPUT_LOCATOR).sendKeys(email);

        setWaitForElementVisibility(HEADER_LOGO_IMAGE_BUTTON_LOCATOR);
        getDriver().findElement(HEADER_LOGO_IMAGE_BUTTON_LOCATOR).click();

        return new HomePage(getDriver());
    }

    public CustomizationAdvertPage continueCustomization() {
        setWaitForElementVisibility(CONTINUE_CUSTOMIZATION_BUTTON_LOCATOR);
        getDriver().findElement(CONTINUE_CUSTOMIZATION_BUTTON_LOCATOR).click();
        return this;
    }

    public ChoosePostTypePage publishAdvert() throws InterruptedException {
        Thread.sleep(1000);
        setWaitForElementVisibility(PUBLISH_ADVERT_BUTTON_LOCATOR);
        getDriver().findElement(PUBLISH_ADVERT_BUTTON_LOCATOR).click();
        return new ChoosePostTypePage(getDriver());
    }
}
