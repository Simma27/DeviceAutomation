package ui;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import providers.ScreenshotListener;

import static config.ui.URLconfig.AUTOMATION_PRACTICE;
import static providers.DriverProvider.*;

@Listeners({ScreenshotListener.class})
public abstract class BaseTest {

    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = initializeDriver();
        getDriver().get(AUTOMATION_PRACTICE.getUrl());
    }

    @AfterMethod
    public void finish(ITestResult result) {
        tearDown();
    }
}