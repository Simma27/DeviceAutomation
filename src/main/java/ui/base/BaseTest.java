package ui.base;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ui.listener.ScreenshotListener;

import static ui.config.URLconfig.AUTOMATION_PRACTICE;
import static ui.providers.DriverProvider.*;

@Listeners({ScreenshotListener.class})
public abstract class BaseTest {

    @BeforeMethod
    public void setup() {
        getDriver().get(AUTOMATION_PRACTICE.getUrl());
    }

    @AfterMethod
    public void finish(ITestResult result) {
        tearDown();
    }

}