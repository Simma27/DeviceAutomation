package ui.services.main;

import io.qameta.allure.Step;
import ui.pages.main.ContactUsPage;

import static ui.services.main.HomePageService.submitContactUs;

/**
 * Class intended to work with CUSTOMER SERVICE on "Contact Us" page
 */
public class ContactUsPageService {

    /**
     * Method fill message to Customer Service and send it.
     * @return modal window with result success sending message.
     */
    @Step("Send message to customer service.")
    public static ContactUsPage sendMessage() {
        ContactUsPage contactUsPage = new ContactUsPage();
        submitContactUs();
//        Actions actions = new Actions(getDriver());
//        actions.click(contactUsPage.getSubjectHeading())
//                .click(contactUsPage.getCustomerService())
//                .build().perform();
//        actions.sendKeys(contactUsPage.getMessage(), "I have a problem with my order. Could you help me?")
//                .click(contactUsPage.getOrderReference())
//                .click(contactUsPage.getOrderNumber())
//                .build().perform();
//        actions.click(contactUsPage.getProduct())
//                .click(contactUsPage.getProductName())
//                .click(contactUsPage.getSendButton())
//                .build()
//                .perform();
        contactUsPage.getSubjectHeading().click();
        contactUsPage.getCustomerService().click();
        contactUsPage.getMessage().sendKeys("I have a problem with my order. Could you help me?");
        contactUsPage.getOrderReference().click();
        contactUsPage.getOrderNumber().click();
        contactUsPage.getProduct().click();
        contactUsPage.getProductName().click();
        contactUsPage.getSendButton().click();
        return new ContactUsPage();
    }
}
