package services.ui;

import pages.ShippingPage;

public class ShippingPageService {

    public static void delivery() {
        ShippingPage shippingPage = new ShippingPage();
        shippingPage.getTermsOfServicecheckBox();
        ShippingPage.submitProceedToCheckoutButton();
    }
}
