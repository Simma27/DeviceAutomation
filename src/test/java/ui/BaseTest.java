package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static config.ui.URLconfig.AUTOMATION_PRACTICE;
import static providers.DriverProvider.getDriver;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        getDriver().get(AUTOMATION_PRACTICE.getUrl());
    }

    @AfterMethod
    public void finish() {
//        tearDown();
    }

}
