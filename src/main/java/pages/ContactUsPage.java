package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    @FindBy(id = "id_contact")
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


    public WebElement getOrderReference() {
        return orderReference;
    }

    public WebElement getOrderNumber() {
        return orderNumber;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getSubjectHeading() {
        return subjectHeading;
    }

    public WebElement getCustomerService() {
        return customerService;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public WebElement getProduct() {
        return product;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getResultMessage() {
        return resultMessage;
    }

}
