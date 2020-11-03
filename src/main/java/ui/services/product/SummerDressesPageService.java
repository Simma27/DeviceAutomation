package ui.services.product;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import ui.models.Clothes;
import ui.pages.product.PrintedSummerDressPage;
import ui.pages.product.SummerDressesPage;
import ui.providers.DriverProvider;

import static ui.services.main.HomePageService.chooseClothes;


public class SummerDressesPageService {

    @Step("Switch to printed summer dress page")
    public static PrintedSummerDressPage goToPrintedSummerDressPage() {
        SummerDressesPage page = new SummerDressesPage();
        chooseClothes(Clothes.SUMMER_DRESSES);
        Actions actions = new Actions(DriverProvider.getDriver());
        actions.moveToElement(page.getPrintedSummerDress())
                .click(page.getMoreButton())
                .build()
                .perform();
        return new PrintedSummerDressPage();
    }
}
