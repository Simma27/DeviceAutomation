package services.ui.payment;

import io.qameta.allure.Step;
import pages.payment.ShoppingCartSummaryPage;

/**
 * The class describe page, which consist of your product, price, your delivery address and number of product.
 */
public class ShoppingCartSummaryPageService {

    /**
     * Method confirm product information, price, your delivery address and proceed checkout.
     */
    @Step
    public static void submitProceedToCheckoutButton() {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage();
        shoppingCartSummaryPage.getProceedToCheckoutButton().click();
    }
}