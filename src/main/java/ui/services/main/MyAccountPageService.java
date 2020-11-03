package ui.services.main;

import io.qameta.allure.Step;
import ui.pages.main.MyAccountPage;

import static ui.services.main.HomePageService.submitMyAccount;

/**
 * Class consist of methods to work with "Me account" page
 */
public class MyAccountPageService {
    /**
     * The method unfold wishlist.
     * @return opened wishlist
     */
    @Step("Get your wish list.")
    public static MyAccountPage getWishlist() {
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
        MyAccountPage page = new MyAccountPage();
        page.submitRemoveWishlistButton();
        }
    }

