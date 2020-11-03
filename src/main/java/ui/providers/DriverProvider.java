package ui.providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * The class provide WebDriver for testing framework.
 */
public final class DriverProvider {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        if (DRIVER.get() == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\work\\Drivers\\SeleniumWebDriver\\chromedriver.exe");
            DRIVER.set(new ChromeDriver());
            DRIVER.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            DRIVER.get().manage().window().maximize();
        }
        return DRIVER.get();
    }

    public static void tearDown() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
