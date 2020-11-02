package services.ui.product;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import pages.product.PrintedSummerDressPage;
import pages.product.SummerDressesPage;

import static pages.main.BasePage.getDriver;

public class SummerDressesPageService {
    @Step
    public static PrintedSummerDressPage goToPrintedSummerDress() {
        SummerDressesPage page = new SummerDressesPage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(page.getPrintedSummerDress())
                .click(page.getMoreButton())
                .build()
                .perform();
        return new PrintedSummerDressPage();
    }
}
//    @Override
//    public void onTestFailure(ITestResult tr)
//    { Object currentClass = tr.getInstance();
//    WebDriver driver = ((AbstractTest) currentClass).getDriver();
//    byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    saveScreenshot(srcFile); }
//    @Attachment(value = "Page screenshot", type = "image/png")
//    private byte[] saveScreenshot(byte[] screenshot)
//    { return screenshot; }
