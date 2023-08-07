package stepsDefinition;

import PageObjects.ContactUsPageObject;
import appHooks.Hooks;
import com.google.common.base.Verify;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("Click Send Message button")
    public void clickSendMessageButton() {
        contactUsPage.clickSendMessageButton();
    }

    @Then("Verify error message at mandatory fields")
    public void verifyErrorMessageAtMandatoryFields() {
        Assert.assertEquals(contactUsPage.getErrorMessageByName("mf-first-name"), "This field is required.");
        Assert.assertEquals(contactUsPage.getErrorMessageByName("mf-last-name"), "This field is required.");
        Assert.assertEquals(contactUsPage.getErrorMessageByName("mf-email"), "This field is required.");
        Assert.assertEquals(contactUsPage.getErrorMessageByName("mf-subject"), "This field is required.");
        Assert.assertEquals(contactUsPage.getCommentsErrMsg(), "This field is required.");
        Assert.assertEquals(contactUsPage.getErrorMessageByName("g-recaptcha-response"), "reCAPTCHA is required");
    }

    @Given("User enters valid data into FirstName and LastName")
    public void userEntersValidDataIntoFirstNameAndLastName() {
    }

    @And("^User enters invalid (.*) into Email field$")
    public void userEntersInvalidIntoEmailField(String email) {
    }

    @And("User enters valid data into Subjects field")
    public void userEntersValidDataIntoSubjectsField() {
    }

    @Then("Verify error message at Email field")
    public void verifyErrorMessageAtEmailField() {
    }
}
