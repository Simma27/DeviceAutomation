package ui.services.product;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import ui.models.Clothes;
import ui.pages.product.CatalogPage;
import ui.providers.DriverProvider;

import static ui.services.main.HomeService.chooseClothes;

/**
 * The class consist of methods to work with Catalog, switch to another product page.
 */
public class CatalogService {

    /**
     * Method allows to go to checkout
     */
    @Step
    public static void goToPurchase() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.submitAddToCartPrintesDressButton();
        catalogPage.submitProceedToCheckoutButton();
    }

    /**
     * Method switch to Faded Short Sleeve T-shirts Page
     */
    @Step
    public static void goToFadedShortSleeveTshirtsPage() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.submitMoreTshirtButton();
    }

    /**
     * Method switch to Blouse Page
     */
    @Step("Switch to Blouse page.")
    public static void goToBlousePage() {
        CatalogPage catalogPage = new CatalogPage();
        chooseClothes(Clothes.BLOUSES);
        catalogPage.submitMoreBlouseButton();
    }
}

