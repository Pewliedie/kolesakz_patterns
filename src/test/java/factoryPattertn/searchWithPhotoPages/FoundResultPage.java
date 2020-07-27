package factoryPattertn.searchWithPhotoPages;

import factoryPattertn.AbstractPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;

public class FoundResultPage extends AbstractPageFactory {

    @FindBy(css = "button.kl-button.kl-button.js__tutorial-close")
    WebElement dismissHintButton;

    public FoundResultPage(WebDriver driver) {
        super(driver);
    }

    public FoundResultPage switchTab(){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return this;
    }

    public FoundResultPage dismissHint(){
        wait.until(ExpectedConditions.elementToBeClickable(dismissHintButton));
        dismissHintButton.click();
        return this;
    }

    public FoundResultPage checkPicture(){
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[@class='gallery__main js__gallery-main']//picture//img"))
                .isDisplayed(),"picture is not presented");
        return this;
    }
}
