package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends BasePage {

    public WebElement getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }

    @FindBy(css = ".standard-checkout > span")
    private WebElement proceedToCheckoutButton;

}
