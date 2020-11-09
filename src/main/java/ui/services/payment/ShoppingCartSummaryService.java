package ui.services.payment;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import ui.pages.payment.ShoppingCartSummaryPage;

/**
 * The class describe page, which consist of your product, price, your delivery address and number of product.
 */
@Log4j2
public class ShoppingCartSummaryService {

    /**
     * Method confirm product information, price, your delivery address and proceed checkout.
     */
    @Step("Confirm shopping cart summary.")
    public static void submitProceedToCheckoutButton() {
        log.info("Step: Confirm shopping cart summary, method: submitProceedToCheckoutButton()");
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage();
        shoppingCartSummaryPage.getProceedToCheckoutButton();
    }
}