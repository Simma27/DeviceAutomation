package ui.services.product;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import ui.models.Clothes;
import ui.pages.product.PrintedSummerDressPage;
import ui.pages.product.SummerDressesPage;
import ui.providers.DriverProvider;

import static ui.services.main.HomeService.chooseClothes;


public class SummerDressesService {
    /**
     * Switch to printed summer dress page.
     * @return page with information about printed summer dress.
     */
    @Step("Switch to printed summer dress page")
    public static PrintedSummerDressPage goToPrintedSummerDressPage() {
        SummerDressesPage page = new SummerDressesPage();
        chooseClothes(Clothes.SUMMER_DRESSES);
        return page.submitMoreButton();
    }
}
