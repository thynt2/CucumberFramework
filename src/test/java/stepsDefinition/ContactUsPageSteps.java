package stepsDefinition;

import PageObjects.ContactUsPageObject;
import appHooks.Hooks;
import com.google.common.base.Verify;
import common.PageGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ContactUsPageSteps {

    WebDriver driver;
    ContactUsPageObject contactUsPage;

    public ContactUsPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        contactUsPage = PageGenerator.getContactUsPage(driver);
    }

    @Then("Verify Contact Us page is displayed")
    public void verifyContactUsPageIsDisplayed() {
        Assert.assertTrue(contactUsPage.isContactUsPageDisplayed());
    }

    @Given("User is navigate back to Home Page")
    public void userIsNavigateBackToHomePage() {
        contactUsPage.backToPage(driver);
    }
}
