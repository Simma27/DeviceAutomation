package ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.main.BasePage;

/**
 * The class describe WebElements Catalog page.
 */
public class CatalogPage extends BasePage {

    @FindBy(css = "[alt='Printed Dress']")
    private WebElement printedDress;
    @FindBy(css = ".ajax_add_to_cart_button > span:nth-child(1)")
    private WebElement addToCartButton;
    @FindBy(css = "a.button-medium > span:nth-child(1)")
    private WebElement proceedToCheckoutButton;
    @FindBy(css = "[alt='Faded Short Sleeve T-shirts']")
    private WebElement tshirt;
    @FindBy(css = ".button.lnk_view.btn.btn-default span")
    private WebElement moreTshirtButton;
    @FindBy(css = ".right-block")
    private WebElement blouse;
    @FindBy(css = ".lnk_view > span:nth-child(1)")
    private WebElement moreBlouseButton;

    public void submitProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public WebElement getPrintedDress() {
        return printedDress;
    }

    public WebElement AddToCartButton() {
        return addToCartButton;
    }

    public WebElement getMoreTshirtButton() {
        return moreTshirtButton;
    }

    public WebElement getTshirt() {
        return tshirt;
    }

    public WebElement getBlouse() {
        return blouse;
    }

    public WebElement getMoreBlouseButton() {
        return moreBlouseButton;
    }


}
