package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static providers.DriverProvider.getDriver;

/**
 * Parent class of pages for implementing the PageObject pattern.
 */
public class BasePage {

    protected WebDriver driver;

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

}