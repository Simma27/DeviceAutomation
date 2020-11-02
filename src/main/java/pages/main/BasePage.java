package pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Parent class of pages for implementing the PageObject pattern.
 */
public class BasePage {

    private WebDriver driver;
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\work\\Drivers\\SeleniumWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().fullscreen();
        DRIVER.set(driver);
        return DRIVER.get();
    }

    public static synchronized WebDriver getDriver() {
        return DRIVER.get();
    }


    public static void tearDown() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }

}