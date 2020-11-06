package ui.services.main;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import ui.pages.main.MyAccountPage;

import static ui.services.main.HomeService.submitMyAccount;

/**
 * Class consist of methods to work with "Me account" page
 */
@Log4j2
public class MyAccountService {
    /**
     * The method unfold wishlist.
     * @return opened wishlist
     */
    @Step("Get your wish list.")
    public static MyAccountPage getWishlist() {
        log.info("Get your wish list.");
        MyAccountPage page = new MyAccountPage();
        submitMyAccount();
        page.submitMyWishlistButton();
        return page.submitGetwishlistButton();
    }

    /**
     * The method remove wishlist
     */
    @Step("Remove wish list.")
    public static void removeWishlist() {
        log.info("Remove wish list.");
        MyAccountPage page = new MyAccountPage();
        page.submitRemoveWishlistButton();
        }
}

