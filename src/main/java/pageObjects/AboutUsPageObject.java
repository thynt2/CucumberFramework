package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;

public class AboutUsPageObject extends BasePage {
    WebDriver driver;

    public AboutUsPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
