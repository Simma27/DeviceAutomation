package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(css = ".bankwire")
    private WebElement payByBankWireButton;
    @FindBy(css = "button.button-medium > span")
    private WebElement confirmOrder;

    @FindBy(css = ".cheque-indent > strong:nth-child(1)")
    private WebElement orderResult;
    @FindBy(css = ".box > strong:nth-child(13)")
    private WebElement message;

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


}
