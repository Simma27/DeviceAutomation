package ui;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ui.listener.ScreenshotListener;

import static ui.config.URLconfig.AUTOMATION_PRACTICE;

@Listeners({ScreenshotListener.class})
public abstract class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver initializeDriver();
        getDriver().get(AUTOMATION_PRACTICE.getUrl());
    }

    @AfterMethod
    public void finish(ITestResult result) {
        tearDown();
    }

}