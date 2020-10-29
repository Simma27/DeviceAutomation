package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends BasePage {

    @FindBy(css = "button.button:nth-child(4) > span:nth-child(1)")
    private WebElement proceedToCheckoutButton;

    public void submitProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}
