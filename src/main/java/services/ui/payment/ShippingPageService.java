package services.ui.payment;

import io.qameta.allure.Step;
import pages.payment.ShippingPage;

/**
 * The class consists of methods for selecting and checking product delivery.
 */
public class ShippingPageService {

    /**
     * Method allow to agree to the terms of service
     */
    @Step
    public static void delivery() {
        ShippingPage shippingPage = new ShippingPage();
        shippingPage.getTermsOfServicecheckBox();
        ShippingPage.submitProceedToCheckoutButton();
    }
}
