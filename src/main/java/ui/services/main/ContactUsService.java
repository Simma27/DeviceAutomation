package ui.services.main;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import ui.pages.main.ContactUsPage;

import static ui.services.main.HomeService.submitContactUs;

/**
 * Class intended to work with CUSTOMER SERVICE on "Contact Us" page
 */
@Log4j2
public class ContactUsService {

    /**
     * Method fill message to Customer Service and send it.
     * @return modal window with result success sending message.
     */
    @Step("Send message to customer service.")
    public static ContactUsPage sendMessage() {
        log.info("Send message to customer service.");
        ContactUsPage contactUsPage = new ContactUsPage();
        submitContactUs();
        contactUsPage.submitSubjectHeading();
        contactUsPage.submitCustomerService();
        contactUsPage.enterMessage("I have a problem with my order. Could you help me?");
        contactUsPage.submitOrderReference();
        contactUsPage.submitOrderNumber();
        contactUsPage.submitProduct();
        contactUsPage.submitProductName();
        return contactUsPage.sumbitSendButton();
    }
}
