package factoryPattertn.advancedSearch;

import factoryPattertn.searchWithPhotoTest.FoundResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResultPage extends FoundResultPage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage assertResults(){
        Assert.assertTrue(driver.findElement(By.xpath("//dl[8][contains(.,'полный привод')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//dl[2][contains(.,'седан')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//dd[contains(.,'6.7')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//dl[6][contains(.,'слева')]")).isDisplayed());
        return this;
    }
}
