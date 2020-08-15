package ui_tests;

import com.codeborne.selenide.Configuration;
import com.epam.cdp.kzta2020.common.config.ConfigReader;
import com.epam.cdp.kzta2020.domain.DataFactory;
import com.epam.cdp.kzta2020.domain.SearchWithPhotoData;
import com.epam.cdp.kzta2020.pages.search.search_with_photo_selenide_bonus_task.FoundResultPage;
import com.epam.cdp.kzta2020.pages.search.search_with_photo_selenide_bonus_task.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class KolesaSelenideBonusTask {
    private final com.epam.cdp.kzta2020.common.config.Configuration configuration = ConfigReader.getConfiguration();

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        open(configuration.getBaseUrl());
    }

    @Test
    public void searchWithPhoto() {
        SearchWithPhotoData kolesaSearchWithPhotoData = DataFactory.getSearchWithPhotoCarData();
        HomePage pageSearch = new HomePage();
        pageSearch.openAutoSection();
        pageSearch.configureSearch(kolesaSearchWithPhotoData).enablePhotoCheckbox()
                .showResult().openFoundResult();

        FoundResultPage foundResultPage = new FoundResultPage().switchTab();
        foundResultPage.dismissHint();
        Assert.assertTrue(foundResultPage.isImageDisplayed(), "picture is not displayed");
    }
}
