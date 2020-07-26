package pageObjectPattern;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AbstractPage {
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECOND = 20;
    private WebDriver driver;
    protected SoftAssert softAssert;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        softAssert = new SoftAssert();
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    public void setWaitForElementVisibility(By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECOND).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void setWaitForElementEnabled(By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECOND).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void isAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException ignored) {
        }
        catch (TimeoutException ignored){
        }
    }
}
