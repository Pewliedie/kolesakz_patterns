package factoryPattertn.advancedSearchPages;

import factoryPattertn.searchWithPhotoPages.FoundResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends FoundResultPage {

    private static final String BODY_TYPE = "внедорожник";
    private static final String DRIVE_UNIT = "полный привод";
    private static final String ENGINE_VOLUME = "6.7 (бензин)";
    private static final String LOCATION_OF_WHEEL = "слева";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage assertResults(){
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[3]//dd")).getText(), BODY_TYPE, "parameter does not match");
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[4]//dd")).getText(), ENGINE_VOLUME, "parameter does not match");
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[7]/dd")).getText(), LOCATION_OF_WHEEL, "parameter does not match");
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[9]//dd")).getText(), DRIVE_UNIT, "parameter does not match");
        softAssertion.assertAll();
        return this;
    }
}
