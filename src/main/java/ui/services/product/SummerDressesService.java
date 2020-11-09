package ui.services.product;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.models.Clothes;
import ui.pages.product.PrintedSummerDressPage;
import ui.pages.product.SummerDressesPage;

import static ui.services.main.HomeService.chooseClothes;
/**
 * The class consist of methods to work with Summer dresses page.
 */
@Log4j2
public class SummerDressesService {
    /**
     * Switch to printed summer dress page.
     * @return page with information about printed summer dress.
     */
    @Step("Switch to printed summer dress page")
    public static PrintedSummerDressPage goToPrintedSummerDressPage() {
        log.info("Step: Switch to printed summer dress page, method: goToPrintedSummerDressPage()");
        log.info("Switch to printed summer dress page");
        SummerDressesPage page = new SummerDressesPage();
        chooseClothes(Clothes.SUMMER_DRESSES);
        return page.submitMoreButton();
    }
}
