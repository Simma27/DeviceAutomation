package ui.pages.payment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;

/**
 * The class describe WebElements Shopping Cart Summary page.
 */
public class ShoppingCartSummaryPage extends BasePage {

    @FindBy(css = ".standard-checkout > span")
    private WebElement proceedToCheckoutButton;

    public void getProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

}