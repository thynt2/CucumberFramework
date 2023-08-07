package PageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToHayWorkLogoInHeader() {
        waitForElementClickable(driver, HomePageUI.hayworkLogoHeader);
        clickToElement(driver, HomePageUI.hayworkLogoHeader);
    }

    public boolean isHomePageDisplayed() {
        waitForElementVisible(driver, HomePageUI.homePageText);
        return isElementDisplayed(driver, HomePageUI.homePageText);
    }

    public void clickToRequestADemoButton() {
        waitForElementClickable(driver, HomePageUI.requestDemoBtn);
        clickToElement(driver, HomePageUI.requestDemoBtn);
    }

    public void clickToGetStartedNowButton() {
        moveToElement(driver, HomePageUI.getStartedNowBtn);
        waitForElementClickable(driver, HomePageUI.getStartedNowBtn);
        clickToElement(driver, HomePageUI.getStartedNowBtn);
    }

    public boolean isHayWorkLogoInFooterDisplayed() {
        waitForElementVisible(driver, HomePageUI.hayworkLogoFooter);
        return isElementDisplayed(driver, HomePageUI.hayworkLogoFooter);
    }

    public boolean isLinkedInIconDisplayed() {
        waitForElementVisible(driver, HomePageUI.linkedInIcon);
        return isElementDisplayed(driver, HomePageUI.linkedInIcon);
    }

    public boolean isFacebookIconDisplayed() {
        waitForElementVisible(driver, HomePageUI.facebookIcon);
        return isElementDisplayed(driver, HomePageUI.facebookIcon);
    }

    public boolean isTwitterIconDisplayed() {
        waitForElementVisible(driver, HomePageUI.twitterIcon);
        return isElementDisplayed(driver, HomePageUI.twitterIcon);
    }
}

