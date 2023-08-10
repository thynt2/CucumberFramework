package stepsDefinition;

import PageObjects.ContactUsPageObject;
import Utils.ExcelReader;
import appHooks.Hooks;
import common.BaseTest;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContactUsPageSteps extends BaseTest {

    WebDriver driver;
    ContactUsPageObject contactUsPage;
    String projectPath = System.getProperty("user.dir");

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
        verifyEquals(contactUsPage.getErrorMessageByName("g-recaptcha-response"), "reCAPTCHA is required.");
        assertAll();
    }

    @Given("User fill the form from given sheetName {string} and rowNumber {int}")
    public void userFillTheFormFromGivenSheetNameAndRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {

        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData(projectPath + "/src/test/resources/testData/automation.xlsx", sheetName);
        String firstName = testData.get(rowNumber).get("firstname");
        String lastName = testData.get(rowNumber).get("lastname");
        String email = testData.get(rowNumber).get("email");
        String subject = testData.get(rowNumber).get("subject");
        String comment = testData.get(rowNumber).get("comment");

        contactUsPage.fillContactUsForm(firstName, lastName, email, subject, comment);
    }
}
