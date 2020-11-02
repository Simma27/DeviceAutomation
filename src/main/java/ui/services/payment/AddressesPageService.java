package ui.services.payment;

import io.qameta.allure.Step;
import ui.pages.payment.AddressesPage;

/**
 * Class consist of methods to fill and check address information in payment.
 */
public class AddressesPageService {

    /**
     * Method confirm address information and proceed checkout.
     */
    @Step
    public static void submitProceedToCheckoutButton() {
        AddressesPage addressesPage = new AddressesPage();
        addressesPage.submitProceedToCheckoutButton();
    }

}