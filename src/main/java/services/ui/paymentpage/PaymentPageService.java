package services.ui.paymentpage;

import pages.PaymentPage;

public class PaymentPageService {

    public static PaymentPage registrationOfPurchase() {
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.submitPayByBankWireButton();
        return paymentPage.submitConfirmOrder();
    }

    public static class AddressesPageService {

        public static void submitProceedToCheckoutButton() {
            PaymentPage.AddressesPage addressesPage = new PaymentPage.AddressesPage();
            addressesPage.submitProceedToCheckoutButton();
        }

    }

    public static class ShippingPageService {

        public static void delivery() {
            PaymentPage.ShippingPage shippingPage = new PaymentPage.ShippingPage();
            shippingPage.getTermsOfServicecheckBox();
            PaymentPage.ShippingPage.submitProceedToCheckoutButton();
        }
    }

    public static class ShoppingCartSummaryPageService {

        public static void submitProceedToCheckoutButton() {
            PaymentPage.ShoppingCartSummaryPage shoppingCartSummaryPage = new PaymentPage.ShoppingCartSummaryPage();
            shoppingCartSummaryPage.getProceedToCheckoutButton().click();
        }
    }
}
