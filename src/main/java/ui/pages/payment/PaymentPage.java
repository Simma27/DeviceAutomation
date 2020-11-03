package ui.pages.payment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;

/**
 * The class describe WebElements Payment page.
 */
public class PaymentPage extends BasePage {

    @FindBy(css = ".bankwire")
    private WebElement payByBankWireButton;

    @FindBy(css = "button.button-medium > span")
    private WebElement confirmOrder;

    @FindBy(css = ".cheque-indent > strong:nth-child(1)")
    private WebElement orderResult;

    @FindBy(css = ".box > strong:nth-child(13)")
    private WebElement message;

    @FindBy(css = ".price strong")
    private WebElement price;

    @FindBy(css = "#center_column > div > strong:nth-child(5)")
    private WebElement nameOfAccountOwner;

    @FindBy(css = "#center_column > div > strong:nth-child(7)")
    private WebElement details;

    @FindBy(css = "#center_column > div > strong:nth-child(9)")
    private WebElement bankName;

    public void submitPayByBankWireButton() {
        payByBankWireButton.click();
    }

    public PaymentPage submitConfirmOrder() {
        confirmOrder.click();
        return new PaymentPage();
    }

    public String getOrderResult() {
        return orderResult.getText();
    }

    public String getMessage() {
        return message.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getNameOfAccountOwner() {
        return nameOfAccountOwner.getText();
    }

    public String getDetails() {
        return details.getText();
    }

    public String getBankName() {
        return bankName.getText();
    }


}
