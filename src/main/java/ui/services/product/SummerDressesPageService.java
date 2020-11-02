package ui.services.product;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import ui.pages.product.PrintedSummerDressPage;
import ui.pages.product.SummerDressesPage;
import ui.providers.DriverProvider;

import static ui.services.main.HomePageService.chooseSummerDresses;

public class SummerDressesPageService {
    @Step
    public static PrintedSummerDressPage goToPrintedSummerDressPage() {
        SummerDressesPage page = new SummerDressesPage();
        chooseSummerDresses();
        Actions actions = new Actions(DriverProvider.getDriver());
        actions.moveToElement(page.getPrintedSummerDress())
                .click(page.getMoreButton())
                .build()
                .perform();
        return new PrintedSummerDressPage();
    }
}
