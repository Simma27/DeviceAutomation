package ui.services.product;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.interactions.Actions;
import ui.models.Clothes;
import ui.pages.product.CatalogPage;
import ui.providers.DriverProvider;

import static ui.services.main.HomeService.chooseClothes;

/**
 * The class consist of methods to work with Catalog, switch to another product page.
 */
@Log4j2
public class CatalogService {

    /**
     * Method allows to go to checkout
     */
    @Step("Go to purchase")
    public static void goToPurchase() {
        log.info("Step: Go to purchase, method: goToPurchase()");
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.submitAddToCartPrintesDressButton();
        catalogPage.submitProceedToCheckoutButton();
    }

    /**
     * Method switch to Faded Short Sleeve T-shirts Page
     */
    @Step("Switch to Faded Short Sleeve T-shirts Page.")
    public static void goToFadedShortSleeveTshirtsPage() {
        log.info("Step: Switch to Faded Short Sleeve T-shirts Page, method: goToFadedShortSleeveTshirtsPage()");
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.submitMoreTshirtButton();
    }

    /**
     * Method switch to Blouse Page
     */
    @Step("Switch to Blouse page.")
    public static void goToBlousePage() {
        log.info("Step: Switch to Blouse page, method: goToBlousePage()");
        CatalogPage catalogPage = new CatalogPage();
        chooseClothes(Clothes.BLOUSES);
        catalogPage.submitMoreBlouseButton();
    }
}

