package ui.services.main;

import io.qameta.allure.Step;
import ui.pages.main.ContactUsPage;

/**
 * Class intended to work with CUSTOMER SERVICE on "Contact Us" page
 */
public class ContactUsPageService {

    /**
     * Method fill message to Customer Service and send it.
     * @return modal window with result success sending message.
     */
    @Step
    public static ContactUsPage sendMessage() {
        ContactUsPage contactUsPage = new ContactUsPage();
//        Actions actions = new Actions(getDriver());
//        actions.clickAndHold(contactUsPage.getSubjectHeading())
//                .clickAndHold(contactUsPage.getCustomerService())
//                .clickAndHold(contactUsPage.getOrderReference())
//                .clickAndHold(contactUsPage.getOrderNumber())
//                .clickAndHold(contactUsPage.getProduct())
//                .clickAndHold(contactUsPage.getProductName())
//                .sendKeys(contactUsPage.getMessage(), "I have a problem with my order. Could you help me?")
//                .clickAndHold(contactUsPage.getSendButton())
//                .build().perform();
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
