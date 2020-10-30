package services.ui.productpage;

import org.openqa.selenium.interactions.Actions;
import pages.CatalogPage;

import static providers.DriverProvider.getDriver;

public class CatalogPageService {

    public static void goToPurchase() {
        CatalogPage catalogPage = new CatalogPage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(catalogPage.getPrintedDress())
                .moveToElement(catalogPage.AddToCartButton()).click().build().perform();
        catalogPage.submitProceedToCheckoutButton();
    }

    public static void goToFadedShortSleeveTshirtsPage() {
        CatalogPage catalogPage = new CatalogPage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(catalogPage.getTshirt())
                .click(catalogPage.getMoreTshirtButton())
                .build().perform();
    }

    public static void goToBlousePage() {
        CatalogPage catalogPage = new CatalogPage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(catalogPage.getBlouse())
                .click(catalogPage.getMoreBlouseButton())
                .build().perform();
    }
}

