package ui.providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * The class provide WebDriver for testing framework.
 */
public final class DriverProvider {

    private static volatile DriverProvider provider;

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverProvider(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "C:\\work\\Drivers\\SeleniumWebDriver\\chromedriver.exe");
        DRIVER.set(driver);
        DRIVER.set(new ChromeDriver());
        DRIVER.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DRIVER.get().manage().window().maximize();
    }

    public static synchronized WebDriver getDriver() {
        if (DRIVER.get() == null) {
            provider = new DriverProvider(DRIVER.get());
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
