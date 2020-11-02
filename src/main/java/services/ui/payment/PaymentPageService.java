package services.ui.payment;

import io.qameta.allure.Step;
import pages.payment.PaymentPage;

/**
 * The class consists of different payment methods for orders
 */
public class PaymentPageService {

    /**
     * Method allows you to pay for the order by bank wire.
     * @return result information about order.
     */
    @Step
    public static PaymentPage registrationOfPurchase() {
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.submitPayByBankWireButton();
        return paymentPage.submitConfirmOrder();
    }

}
