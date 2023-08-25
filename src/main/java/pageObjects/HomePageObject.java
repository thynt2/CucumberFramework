package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToHayWorkLogoInHeader() {
        waitForElementClickable(driver, HomePageUI.hayWorkLogoHeader);
        clickToElement(driver, HomePageUI.hayWorkLogoHeader);
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
        waitForElementVisible(driver, HomePageUI.hayWorkLogoFooter);
        return isElementDisplayed(driver, HomePageUI.hayWorkLogoFooter);
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

    public void clickToContactUsButton() {
        waitForElementClickable(driver, HomePageUI.contactUsBtn);
        clickToElement(driver, HomePageUI.contactUsBtn);
    }
}

