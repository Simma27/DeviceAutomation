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


    public static class ShoppingCartSummaryPage extends BasePage {

        public WebElement getProceedToCheckoutButton() {
            return proceedToCheckoutButton;
        }

        @FindBy(css = ".standard-checkout > span")
        private WebElement proceedToCheckoutButton;

    }

    public static class ShippingPage extends BasePage {

        @FindBy(css = "button.button:nth-child(4) > span:nth-child(1)")
        private static WebElement proceedToCheckoutButton;
        @FindBy(id = "cgv")
        private WebElement termsOfServicecheckBox;

        public static void submitProceedToCheckoutButton() {
            proceedToCheckoutButton.click();
        }

        public void getTermsOfServicecheckBox() {
            termsOfServicecheckBox.click();
        }
    }

    public static class AddressesPage extends BasePage {

        @FindBy(css = "button.button:nth-child(4) > span:nth-child(1)")
        private WebElement proceedToCheckoutButton;

        public void submitProceedToCheckoutButton() {
            proceedToCheckoutButton.click();
        }
    }
}
