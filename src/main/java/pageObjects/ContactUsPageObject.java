package pageObjects;

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
    }

    public String getCommentsErrMsg() {
        waitForElementVisible(driver, ContactUsPageUI.comment_errMsg);
        return getElementText(driver, ContactUsPageUI.comment_errMsg);
    }

    public void fillContactUsForm(String firstName, String lastName, String emailId, String subject, String comment) {
        waitForElementVisible(driver, ContactUsPageUI.firstNameTxt);
        sendKeyToElement(driver, ContactUsPageUI.firstNameTxt, firstName);

        waitForElementVisible(driver, ContactUsPageUI.lastNameTxt);
        sendKeyToElement(driver, ContactUsPageUI.lastNameTxt, lastName);

        waitForElementVisible(driver, ContactUsPageUI.emailTxt);
        sendKeyToElement(driver, ContactUsPageUI.emailTxt, emailId);

        waitForElementVisible(driver, ContactUsPageUI.subjectTxt);
        sendKeyToElement(driver, ContactUsPageUI.subjectTxt, subject);

        waitForElementVisible(driver, ContactUsPageUI.commentArea);
        sendKeyToElement(driver, ContactUsPageUI.commentArea, comment);

    }
}
