package services.ui;

import pages.PaymentPage;

public class PaymentPageService {

    public static PaymentPage registrationOfPurchase() {
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.submitPayByBankWireButton();
        return paymentPage.submitConfirmOrder();
    }
}
