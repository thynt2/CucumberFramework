package PageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ContactUsPageUI;

public class ContactUsPageObject extends BasePage {
    WebDriver driver;

    public ContactUsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isContactUsPageDisplayed() {
        waitForElementVisible(driver, ContactUsPageUI.contactUsText);
        return isElementDisplayed(driver, ContactUsPageUI.contactUsText);
    }
}
