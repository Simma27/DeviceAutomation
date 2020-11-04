package ui.providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * The class provide WebDriver for testing framework.
 */
public final class DriverProvider {


    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        if (DRIVER.get() == null) {
            RemoteWebDriver remoteWebDriver;
            final DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "86.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("screenResolution", "1920x1080x24");
            try {
                remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
                remoteWebDriver.manage().window().maximize();
                remoteWebDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
                DRIVER.set(remoteWebDriver);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return DRIVER.get();
    }

//    public static synchronized WebDriver getDriver() {
//        if (DRIVER.get() == null) {
//            System.setProperty("webdriver.chrome.driver", "C:\\work\\Drivers\\SeleniumWebDriver\\chromedriver.exe");
//            DRIVER.set(new ChromeDriver());
//            DRIVER.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            DRIVER.get().manage().window().maximize();
//        }
//        return DRIVER.get();
//    }

    public static void tearDown() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
