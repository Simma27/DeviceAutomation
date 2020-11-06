package ui.pages.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;

/**
 * THe class describes WebElements Contact Us page.
 */
public class ContactUsPage extends BasePage {

    @FindBy(css = "#id_contact")
    private WebElement subjectHeading;

    @FindBy(css = "option[value='2']")
    private WebElement customerService;

    @FindBy(css = "[name='id_order']")
    private WebElement orderReference;

    @FindBy(css = "[name='id_order'] option:last-child")
    private WebElement orderNumber;

    @FindBy(css = "[name='id_product']")
    private WebElement product;

    @FindBy(css = "[name='id_product']:last-child")
    private WebElement productName;

    @FindBy(css = "#submitMessage > span:nth-child(1)")
    private WebElement sendButton;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(css = ".alert")
    private WebElement resultMessage;

    public void submitOrderReference() {
        orderReference.click();
    }

    public void submitOrderNumber() {
        orderNumber.click();
    }

    public void submitProductName() {
        productName.click();
    }

    public void submitSubjectHeading() {
        subjectHeading.click();
    }

    public void submitCustomerService() {
        customerService.click();
    }

    public ContactUsPage sumbitSendButton() {
        sendButton.click();
        return new ContactUsPage();
    }

    public void submitProduct() {
        product.click();
    }

    public void enterMessage(String messag) {
        message.sendKeys(messag);
    }

    public String getResultMessage() {
        return resultMessage.getText();
    }

}
