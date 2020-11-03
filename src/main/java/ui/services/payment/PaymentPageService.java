package ui.services.payment;

import io.qameta.allure.Step;
import ui.pages.payment.PaymentPage;

import static ui.services.payment.ShippingPageService.delivery;
import static ui.services.product.CatalogPageService.goToPurchase;

/**
 * The class consists of different payment methods for orders
 */
public class PaymentPageService {

    /**
     * Method allows you to pay for the order by bank wire.
     * @return result information about order.
     */
    @Step("Register purchase.")
    public static PaymentPage registrationOfPurchase() {
        PaymentPage paymentPage = new PaymentPage();
        goToPurchase();
        ShoppingCartSummaryPageService.submitProceedToCheckoutButton();
        AddressesPageService.submitProceedToCheckoutButton();
        delivery();
        paymentPage.submitPayByBankWireButton();
        return paymentPage.submitConfirmOrder();
    }



}
