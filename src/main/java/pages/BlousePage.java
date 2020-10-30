package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlousePage extends BasePage {

    @FindBy(id = "wishlist_button")
    private WebElement wishlistButton;
    @FindBy(css = ".fancybox-error")
    private WebElement resultMessage;

    @FindBy(css = ".fancybox-item.fancybox-close")
    private WebElement quitMessage;

    public BlousePage submitWishlistButton() {
        wishlistButton.click();
        return new BlousePage();
    }

    public String getResultMessage() {
        return resultMessage.getText();
    }

    public BlousePage submitQuitMessage() {
        quitMessage.click();
        return new BlousePage();
    }
}
