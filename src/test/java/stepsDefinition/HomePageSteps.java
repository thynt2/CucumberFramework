package stepsDefinition;

import appHooks.Hooks;
import common.BasePage;
import PageObjects.HomePageObject;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePageSteps extends BasePage {

    WebDriver driver;
    HomePageObject homePage;

    public HomePageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        homePage = PageGenerator.getHomePage(driver);
    }

    @When("Click on HayWorkGlobal logo")
    public void clickOnHayWorkGlobalLogo() {
        homePage.clickToHayWorkLogoInHeader();
    }

    @Then("Home page is loaded success")
    public void homePageIsLoadedSuccess() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("Click on Request A Demo button")
    public void clickOnRequestADemoButton() {
        homePage.clickToRequestADemoButton();
    }

    @When("Click on Get Started Now button")
    public void clickOnGetStartedNowButton() {
        homePage.clickToGetStartedNowButton();
    }

    @When("Scroll to footer of page")
    public void scrollToFooterOfPage() {
        homePage.scrollToBottomPage(driver);
    }

    @Then("Verify HayWorkGlobal logo is displayed")
    public void verifyHayWorkGlobalLogoIsDisplayed() {
        Assert.assertTrue(homePage.isHayWorkLogoInFooterDisplayed());
    }

    @And("LinkedIn icon is displayed")
    public void linkedinIconIsDisplayed() {
        Assert.assertTrue(homePage.isLinkedInIconDisplayed());
    }

    @And("Facebook icon is displayed")
    public void facebookIconIsDisplayed() {
        Assert.assertTrue(homePage.isFacebookIconDisplayed());
    }

    @And("Twitter icon is displayed")
    public void twitterIconIsDisplayed() {
        Assert.assertTrue(homePage.isTwitterIconDisplayed());
    }

    @When("Click on Contact Us button in header")
    public void clickOnContactUsButtonInHeader() {
        homePage.clickToContactUsButton();
    }
}
