package common;

import PageObjects.AboutUsPageObject;
import PageObjects.ContactUsPageObject;
import PageObjects.HomePageObject;
import PageObjects.ServicesPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static ContactUsPageObject getContactUsPage(WebDriver driver) {
        return new ContactUsPageObject(driver);
    }

    public static AboutUsPageObject getAboutUsPage(WebDriver driver) {
        return new AboutUsPageObject(driver);
    }

    public static ServicesPageObject getServicesPage(WebDriver driver) {
        return new ServicesPageObject(driver);
    }
}
