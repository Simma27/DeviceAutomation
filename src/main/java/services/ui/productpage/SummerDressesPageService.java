package services.ui.productpage;

import org.openqa.selenium.interactions.Actions;
import pages.PrintedSummerDressPage;
import pages.SummerDressesPage;

import static providers.DriverProvider.getDriver;

public class SummerDressesPageService {

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
