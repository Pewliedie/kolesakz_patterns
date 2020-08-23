package com.epam.cdp.kzta2020.cucumber.step_definitions;

import com.epam.cdp.kzta2020.domain.DataFactory;
import com.epam.cdp.kzta2020.pages.BasePage;
import com.epam.cdp.kzta2020.pages.publish_advert.AccountPage;
import com.epam.cdp.kzta2020.pages.publish_advert.CustomizationAdPage;
import com.epam.cdp.kzta2020.pages.publish_advert.DraftPage;
import com.epam.cdp.kzta2020.pages.publish_advert.SignInPage;
import com.epam.cdp.kzta2020.utils.UserCreator;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class PublishAdvertSteps {

    @When("^open signInPage$")
    public void openSignInPage() {
        new BasePage().openSignIn();
    }

    @When("^sign in$")
    public void signIn() {
        new SignInPage().signIn(UserCreator.getUser());
    }

    @When("^customize advert$")
    public void customizeAdvert() {
        new AccountPage().openCustomization().customizeAdvert(DataFactory.getCustomizationData());
    }

    @When("^return on home page$")
    public void returnOnHomePage() {
        new CustomizationAdPage().returnOnHomePage();
    }

    @When("^open account page$")
    public void openAccountPage() {
        new BasePage().openAccountPage();
    }

    @When("^open draft page$")
    public void openDraftPage() {
        new AccountPage().openDraft();
    }

    @When("^publish advert from customization$")
    public void publishAdvertFromCustomization() {
        new DraftPage().editAdvert().postAdvertFromCustomization().chooseType().chooseFreeAdvert();
    }

    @When("^advert is posted$")
    public void advertIsDisplayed() {
        AccountPage accountPage = new AccountPage();
        Assert.assertTrue(accountPage.isAdvertPosted(), "Advert is not posted");
    }
}
