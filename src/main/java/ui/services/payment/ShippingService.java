package ui.services.payment;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import ui.pages.payment.ShippingPage;

/**
 * The class consists of methods for selecting and checking product delivery.
 */
@Log4j2
public class ShippingService {

    /**
     * Method allow to agree to the terms of service
     */
    @Step("Сonfirm delivery")
    public static void delivery() {
        log.info("Step: Сonfirm delivery, method: delivery()");
        ShippingPage shippingPage = new ShippingPage();
        shippingPage.submitTermsOfServiceCheckBox();
        shippingPage.submitProceedToCheckoutButton();
    }
}
