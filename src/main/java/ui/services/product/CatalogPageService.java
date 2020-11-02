package ui.services.product;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import ui.providers.DriverProvider;
import ui.pages.product.CatalogPage;

/**
 * The class consist of methods to work with Catalog, switch to another product page.
 */
public class CatalogPageService {

    /**
     * Method allows to go to checkout
     */
    @Step
    public static void goToPurchase() {
        CatalogPage catalogPage = new CatalogPage();
        Actions actions = new Actions(DriverProvider.getDriver());
        actions.moveToElement(catalogPage.getPrintedDress())
                .moveToElement(catalogPage.AddToCartButton()).click().build().perform();
        catalogPage.submitProceedToCheckoutButton();
    }

    /**
     * Method switch to Faded Short Sleeve T-shirts Page
     */
    @Step
    public static void goToFadedShortSleeveTshirtsPage() {
        CatalogPage catalogPage = new CatalogPage();
        Actions actions = new Actions(DriverProvider.getDriver());
        actions.moveToElement(catalogPage.getTshirt())
                .click(catalogPage.getMoreTshirtButton())
                .build().perform();
    }

    /**
     * Method switch to Blouse Page
     */
    @Step
    public static void goToBlousePage() {
        CatalogPage catalogPage = new CatalogPage();
        Actions actions = new Actions(DriverProvider.getDriver());
        actions.moveToElement(catalogPage.getBlouse())
                .click(catalogPage.getMoreBlouseButton())
                .build().perform();
    }
}

