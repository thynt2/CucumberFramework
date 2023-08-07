package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    static Actions actions;
    public static BasePage getBasePageObject() {
        return new BasePage();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public WebElement getWebElement(WebDriver driver, String element) {
        return driver.findElement(By.xpath(element));
    }

    public void clickToElement(WebDriver driver, String element) {
        highlightElement(driver, element);
        getWebElement(driver, element).click();
    }

    public void sendKeyToElement(WebDriver driver, String element, String value) {
        highlightElement(driver, element);
        WebElement ele = getWebElement(driver, element);
        ele.clear();
        ele.sendKeys(value);
    }
    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void moveToElement(WebDriver driver, String element){
        actions = new Actions(driver);
        actions.moveToElement(getWebElement(driver,element));
        actions.perform();
        highlightElement(driver, element);
    }


    public String getElementText(WebDriver driver, String element) {
        return getWebElement(driver, element).getText().trim();
    }

    public boolean isElementDisplayed(WebDriver driver, String element) {
        highlightElement(driver, element);
        try {
            return getWebElement(driver, element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForElementClickable(WebDriver driver, String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
    }

    public void waitForElementVisible(WebDriver driver, String element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    public void highlightElement(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, locatorType);
        String originalStyle = element.getAttribute("style");
        String highlightStyle = "border: 2px solid red; border-style: dashed;";
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", highlightStyle);
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void scrollToElement(WebDriver driver, String element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, element));
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}