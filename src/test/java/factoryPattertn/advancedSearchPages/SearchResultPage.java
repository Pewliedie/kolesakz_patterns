package factoryPattertn.advancedSearchPages;

import factoryPattertn.searchWithPhotoPages.FoundResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends FoundResultPage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage assertResults(String bodyType, String engineVolume, String locationOfWheel, String driveUnit) {
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[3]//dd")).getText(), bodyType, "parameter does not match");
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[4]//dd")).getText(), engineVolume, "parameter does not match");
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[7]/dd")).getText(), locationOfWheel, "parameter does not match");
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[9]//dd")).getText(), driveUnit, "parameter does not match");
        softAssertion.assertAll();
        return this;
    }
}
