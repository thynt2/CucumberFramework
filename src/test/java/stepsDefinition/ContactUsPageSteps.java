package stepsDefinition;

import PageObjects.ContactUsPageObject;
import appHooks.Hooks;
import common.BaseTest;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ContactUsPageSteps extends BaseTest {

    WebDriver driver;
    ContactUsPageObject contactUsPage;
//    private final SoftAssertionHelper softAssertionHelper = new SoftAssertionHelper();


    public ContactUsPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        contactUsPage = PageGenerator.getContactUsPage(driver);
    }

    @Then("Verify Contact Us page is displayed")
    public void verifyContactUsPageIsDisplayed() {
        verifyTrue(contactUsPage.isContactUsPageDisplayed());
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
        verifyEquals(contactUsPage.getErrorMessageByName("mf-first-name"), "This field is required.");
        verifyEquals(contactUsPage.getErrorMessageByName("mf-last-name"), "This field is required.");
        verifyEquals(contactUsPage.getErrorMessageByName("mf-email"), "This field is required.");
        verifyEquals(contactUsPage.getErrorMessageByName("mf-subject"), "This field is required.");
        verifyEquals(contactUsPage.getCommentsErrMsg(), "This field is required.");
        verifyEquals(contactUsPage.getErrorMessageByName("g-recaptcha-response"), "This field is required.");
        assertAll();
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
