package ui.services.product;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import ui.pages.product.BlousePage;

/**
 * The class consist of methods to work with Blouse page.
 */
@Log4j2
public class BlouseService {

    /**
     * Method allow to add blouse to your wishlist.
     * @return modal window with result adding blouse to wishlist
     */
    @Step("Add to wish list.")
    public static BlousePage addToWishList() {
        log.info("Add to wish list.");
        BlousePage page = new BlousePage();
        return page.submitWishlistButton();
    }

    /**
     * The method allows to exit the modal window with the result of adding to the wishlist.
     * @return Blouse page
     */
    @Step("Quit message.")
    public static BlousePage quitMessage() {
        log.info("Quit message.");
        BlousePage page = new BlousePage();
        return page.submitQuitMessage();
    }
}
