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

    public String getDynamicXpath(String element, String... dynamicValue) {
        element = String.format(element, (Object[]) dynamicValue);
        return element;
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

    public void moveToElement(WebDriver driver, String element) {
        actions = new Actions(driver);
        actions.moveToElement(getWebElement(driver, element));
        actions.perform();
    }

    public void moveToElement(WebDriver driver, String element, String... dynamicValue) {
        actions = new Actions(driver);
        actions.moveToElement(getWebElement(driver, getDynamicXpath(element, dynamicValue)));
        actions.perform();
    }


    public String getElementText(WebDriver driver, String element) {
        highlightElement(driver, getDynamicXpath(element, element));
        return getWebElement(driver, element).getText().trim();
    }

    public String getElementText(WebDriver driver, String element, String... dynamicValue) {
        highlightElement(driver, getDynamicXpath(element, dynamicValue));
        return getWebElement(driver, getDynamicXpath(element, dynamicValue)).getText().trim();
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

    public void waitForElementClickable(WebDriver driver, String element, String... dynamicValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getDynamicXpath(element, dynamicValue))));
    }

    public void waitForElementVisible(WebDriver driver, String element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    public void waitForElementVisible(WebDriver driver, String element, String... dynamicValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getDynamicXpath(element, dynamicValue))));
    }

    public void highlightElement(WebDriver driver, String element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement ele = getWebElement(driver, element);
        String originalStyle = ele.getAttribute("style");
        String highlightStyle = "border: 2px solid red; border-style: dashed;";
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", ele, "style", highlightStyle);
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", ele, "style", originalStyle);
    }

    public void highlightElement(WebDriver driver, String element, String... dynamicValue) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement ele = getWebElement(driver, element);
        String originalStyle = ele.getAttribute("style");
        String highlightStyle = "border: 2px solid red; border-style: dashed;";
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", ele, "style", highlightStyle);
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", ele, "style", originalStyle);
    }

    public void scrollToElement(WebDriver driver, String element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, element));
    }

    public void clickToElementByJS(WebDriver driver, String element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, element));
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}