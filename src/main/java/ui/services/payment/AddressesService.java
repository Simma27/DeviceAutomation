package ui.services.payment;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import ui.pages.payment.AddressesPage;

/**
 * Class consist of methods to fill and check address information in payment.
 */
@Log4j2
public class AddressesService {

    /**
     * Method confirm address information and proceed checkout.
     */
    @Step("Confirm Address")
    public static void submitProceedToCheckoutButton() {
        log.info("Step: Confirm Address, method: submitProceedToCheckoutButton()");
        AddressesPage addressesPage = new AddressesPage();
        addressesPage.submitProceedToCheckoutButton();
    }

}