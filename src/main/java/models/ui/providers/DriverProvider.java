package models.ui.providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * The class provide WebDriver for the testing framework.
 */
public class DriverProvider {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static void setUp() {
        if (DRIVER.get() == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\work\\Drivers\\SeleniumWebDriver\\chromedriver.exe");
            DRIVER.set(new ChromeDriver());
            DRIVER.get().get("http://automationpractice.com/index.php");
            DRIVER.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            DRIVER.get().manage().window().maximize();
        }
    }

    public static void tearDown() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
