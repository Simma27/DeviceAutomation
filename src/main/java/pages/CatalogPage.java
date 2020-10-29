package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {

    @FindBy(css = "[alt='Printed Dress']")
    private WebElement printedDress;
    @FindBy(css = ".ajax_add_to_cart_button > span:nth-child(1)")
    private WebElement addToCartButton;
    @FindBy(css = "a.button-medium > span:nth-child(1)")
    private WebElement proceedToCheckoutButton;

    public void submitProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public WebElement getPrintedDress() {
        return printedDress;
    }

    public WebElement AddToCartButton() {
        return addToCartButton;
    }


}
