package ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import ui.providers.DriverProvider;

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
    private WebElement tShirt;

    @FindBy(css = ".button.lnk_view.btn.btn-default span")
    private WebElement moreTshirtButton;

    @FindBy(css = ".right-block")
    private WebElement blouse;

    @FindBy(css = ".lnk_view > span:nth-child(1)")
    private WebElement moreBlouseButton;

    public void submitProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void submitAddToCartPrintesDressButton() {
        Actions actions = new Actions(DriverProvider.getDriver());
        actions.moveToElement(printedDress)
                .click(addToCartButton)
                .build().perform();
    }

    public void submitMoreTshirtButton() {
        Actions actions = new Actions(DriverProvider.getDriver());
        actions.moveToElement(tShirt)
                .click(moreTshirtButton)
                .build().perform();
    }

    public void submitMoreBlouseButton() {
        Actions actions = new Actions(DriverProvider.getDriver());
        actions.moveToElement(blouse)
                .click(moreBlouseButton)
                .build().perform();
    }

}
