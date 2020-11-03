package ui.services.payment;

import io.qameta.allure.Step;
import ui.pages.payment.ShippingPage;

/**
 * The class consists of methods for selecting and checking product delivery.
 */
public class ShippingPageService {

    /**
     * Method allow to agree to the terms of service
     */
    @Step("Сonfirm delivery")
    public static void delivery() {
        ShippingPage shippingPage = new ShippingPage();
        shippingPage.getTermsOfServicecheckBox();
        ShippingPage.submitProceedToCheckoutButton();
    }
}
