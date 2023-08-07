package appHooks;

import Utils.PropertiesUtil;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.time.Duration;
import java.util.Properties;


public class Hooks {
    private static WebDriver driver;
    static Properties properties = PropertiesUtil.loadApplicationProperties();

    @Before
    public static synchronized WebDriver openAndQuitBrowser() {

        String url = properties.getProperty("application.url");
        String browser = properties.getProperty("browser.driver");
        if (driver == null) {
            try {
                if (browser == null) {
                    browser = properties.getProperty("browser.driver");
                }
                switch (browser) {
                    case "firefox" -> {
                        WebDriverManager.firefoxdriver().setup();
                        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                        driver = new FirefoxDriver();
                    }
                    case "ie" -> {
                        WebDriverManager.iedriver().arch32().setup();
                        driver = new InternetExplorerDriver();
                    }
                    default -> {
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--remote-allow-origins=*");
                        driver = new ChromeDriver(options);
                    }
                }
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
        return driver;
    }

    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
            }
        } catch (UnreachableBrowserException e) {
            throw new RuntimeException("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }

    }

    @AfterStep
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
