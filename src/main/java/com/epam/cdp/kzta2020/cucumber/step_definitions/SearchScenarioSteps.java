package com.epam.cdp.kzta2020.cucumber.step_definitions;

import com.epam.cdp.kzta2020.business_objects.Car;
import com.epam.cdp.kzta2020.domain.DataFactory;
import com.epam.cdp.kzta2020.driver.WebDriverInitializer;
import com.epam.cdp.kzta2020.pages.BasePage;
import com.epam.cdp.kzta2020.pages.search.advanced_search.FoundResultPage;
import com.epam.cdp.kzta2020.pages.search.advanced_search.HomePage;
import com.epam.cdp.kzta2020.utils.CarBOCreator;
import com.epam.cdp.kzta2020.utils.RandomNumberGenerator;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SearchScenarioSteps {
    @Given("^user navigates to kolesa home page$")
    public void navigate_to_home_page() {
        new BasePage().openHomePage();
    }

    @When("^open auto section$")
    public void openAutoSection() {
        new BasePage().openAutoSection();
    }

    @When("^configure random search \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void configureRandomSearch(String location, String priceFrom, String priceTo, String mark, String model) {
        Car car = CarBOCreator.createCar(location, priceFrom, priceTo, mark, model);
        new HomePage().configureRandomSearch(car);
    }

    @When("^click show results$")
    public void clickShowResults() {
        new HomePage().showResult();
    }

    @When("^open random found result$")
    public void openRandomFoundResult() {
        new HomePage().openRandomFoundResult(RandomNumberGenerator.generateNumber());
    }

    @When("^open found result$")
    public void openFoundResult() {
        new HomePage().openFoundResult();
    }

    @When("^configure search with photo$")
    public void configureSearchWithPhoto() {
        new com.epam.cdp.kzta2020.pages.search.search_with_basic_parameters.HomePage().configureSearch(DataFactory.getSearchWithPhotoCarData());
        new com.epam.cdp.kzta2020.pages.search.search_with_basic_parameters.HomePage().enablePhotoCheckbox();
    }

    @When("^configure search with advanced parameters$")
    public void configureAdvancedSearch() {
        new HomePage().configureAdvancedSearch(DataFactory.getAdvancedSearchData());
    }

    @Then("^random parameters matches with result \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void randomParametersMatchesWithResult(String location, String priceFrom, String priceTo, String mark, String model) {
        SoftAssert softAssert3 = new SoftAssert();
        Car car = CarBOCreator.createCar(location, priceFrom, priceTo, mark, model);
        FoundResultPage foundResultPage = new FoundResultPage().switchTab().dismissHint();
        softAssert3.assertTrue(foundResultPage.isLocationCorrect(car), "parameter does not match");
        softAssert3.assertTrue(foundResultPage.isPriceCorrect(car), "parameter does not match");
        softAssert3.assertTrue(foundResultPage.isMarkCorrect(car), "parameter does not match");
        softAssert3.assertTrue(foundResultPage.isModelCorrect(car), "parameter does not match");
        softAssert3.assertAll();
    }

    @Then("^photo is displayed$")
    public void photoIsDisplayed() {
        FoundResultPage foundResultPage = new FoundResultPage().switchTab().dismissHint();
        Assert.assertTrue(foundResultPage.isImageDisplayed(), "photo is not displayed");
    }

    @Then("^advanced parameters matches with result$")
    public void advancedParametersMatchesWithResult() {
        SoftAssert softAssert2 = new SoftAssert();
        FoundResultPage foundResultPage = new FoundResultPage().switchTab().dismissHint();
        softAssert2.assertTrue(foundResultPage.isBodyTypeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isDriveUnitCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isEngineVolumeCorrect(), "parameter does not match");
        softAssert2.assertTrue(foundResultPage.isLocationOfWheelCorrect(), "parameter does not match");
        softAssert2.assertAll();
    }

    @After
    public void close(){
        WebDriverInitializer.kill();
    }
}
