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

    public void clickSendMessageButton() {
        waitForElementClickable(driver, ContactUsPageUI.sendMessageBtn);
        clickToElementByJS(driver, ContactUsPageUI.sendMessageBtn);
    }

    public String getErrorMessageByName(String fieldName) {
        moveToElement(driver, ContactUsPageUI.errMessageByName, fieldName);
        waitForElementVisible(driver, ContactUsPageUI.errMessageByName, fieldName);
        return getElementText(driver, ContactUsPageUI.errMessageByName, fieldName);
    }public String getCommentsErrMsg() {
        waitForElementVisible(driver, ContactUsPageUI.comment_errMsg);
        return getElementText(driver, ContactUsPageUI.comment_errMsg);
    }
}
