package ui.services.product;

import io.qameta.allure.Step;
import ui.pages.product.BlousePage;

/**
 * The class consist of methods to work with Blouse page.
 */
public class BlouseService {

    /**
     * Method allow to add blouse to your wishlist.
     * @return modal window with result adding blouse to wishlist
     */
    @Step("Add to wish list.")
    public static BlousePage addToWishList() {
        BlousePage page = new BlousePage();
        return page.submitWishlistButton();
    }

    /**
     * The method allows to exit the modal window with the result of adding to the wishlist.
     * @return Blouse page
     */
    @Step("Quit message.")
    public static BlousePage quitMessage() {
        BlousePage page = new BlousePage();
        return page.submitQuitMessage();
    }
}
