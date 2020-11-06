package ui.services.payment;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import ui.pages.payment.PaymentPage;

import static ui.services.payment.ShippingService.delivery;
import static ui.services.product.CatalogService.goToPurchase;

/**
 * The class consists of different payment methods for orders
 */
@Log4j2
public class PaymentService {

    /**
     * Method allows you to pay for the order by bank wire.
     * @return result information about order.
     */
    @Step("Register purchase.")
    public static PaymentPage registrationOfPurchase() {
        log.info("Register purchase.");
        PaymentPage paymentPage = new PaymentPage();
        goToPurchase();
        ShoppingCartSummaryService.submitProceedToCheckoutButton();
        AddressesService.submitProceedToCheckoutButton();
        delivery();
        paymentPage.submitPayByBankWireButton();
        return paymentPage.submitConfirmOrder();
    }



}
