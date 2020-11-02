package providers;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static providers.DriverProvider.getDriver;

public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if (!result.isSuccess()) {
            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() +
                        "/target/surefire-reports";
                File destFile = new File((String) reportDirectory + "/failure_screenshots/" +
                        methodName + "_" + formater.format(calendar.getTime()) + ".png");
                FileUtils.copyFile(scrFile, destFile);
                Allure.addAttachment("My attachment", FileUtils.openInputStream(scrFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
