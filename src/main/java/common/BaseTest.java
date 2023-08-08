package common;

import org.openqa.selenium.WebDriver;
import org.assertj.core.api.SoftAssertions;

public class BaseTest {
    private WebDriver driver;
    private SoftAssertions softAssertions = new SoftAssertions();

    public WebDriver getWebDriver() {
        return this.driver;
    }

    public void verifyEquals(String actual, String expected) {
        softAssertions.assertThat(actual).isEqualTo(expected);
    }

    public void verifyTrue(boolean condition) {
        softAssertions.assertThat(condition).isTrue();
    }

    public void verifyFalse(boolean condition) {
        softAssertions.assertThat(condition).isFalse();
    }

    public void assertAll() {
        softAssertions.assertAll();
    }
}
