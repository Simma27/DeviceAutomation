package ui.pages.payment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.main.BasePage;

/**
 * The class describe WebElements Addresses page.
 */
public class AddressesPage extends BasePage {

    @FindBy(css = "button.button:nth-child(4) > span:nth-child(1)")
    private WebElement proceedToCheckoutButton;

    public void submitProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}
