package ui;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.main.BasePage;
import providers.ScreenshotListener;

import static config.ui.URLconfig.AUTOMATION_PRACTICE;
import static pages.main.BasePage.getDriver;
import static pages.main.BasePage.tearDown;

@Listeners({ScreenshotListener.class})
public abstract class BaseTest {

    WebDriver driver;
    BasePage basePage;

    @BeforeMethod
    public void setup() {
        basePage = new BasePage();
        driver = basePage.initializeDriver();
        getDriver().get(AUTOMATION_PRACTICE.getUrl());
    }

    @AfterMethod
    public void finish(ITestResult result) {
        tearDown();
    }
}