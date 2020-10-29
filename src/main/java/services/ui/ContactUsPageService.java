package services.ui;

import pages.ContactUsPage;

public class ContactUsPageService {

    public static ContactUsPage sendMessage() {
        ContactUsPage contactUsPage = new ContactUsPage();
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(contactUsPage.getSubjectHeading()).click()
//                .moveToElement(contactUsPage.getCustomerService()).click()
////                .click(contactUsPage.getOrderReference())
////                .click(contactUsPage.getOrderNumber())
////                .click(contactUsPage.getProduct())
////                .click(contactUsPage.getProductName())
//                .sendKeys(contactUsPage.getMessage(), "I have a problem with my order. Could you help me?")
////                .click(contactUsPage.getSendButton())
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
