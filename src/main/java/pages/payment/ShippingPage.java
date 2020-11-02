package pages.payment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.main.BasePage;

/**
 * The class describe WebElements Shipping page.
 */
public class ShippingPage extends BasePage {

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