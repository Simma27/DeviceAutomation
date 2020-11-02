package ui.services.main;

import io.qameta.allure.Step;
import ui.pages.main.MyAccountPage;

/**
 * Class consist of methods to work with "Me account" page
 */
public class MyAccountPageService {
    /**
     * The method unfold wishlist.
     * @return opened wishlist
     */
    @Step
    public static MyAccountPage getWishlist() {
        MyAccountPage page = new MyAccountPage();
        page.submitMyWishlistButton();
        return page.submitGetwishlistButton();
    }

    /**
     * The method remove wishlist
     */
    @Step
    public static void removeWishlist() {
        MyAccountPage page = new MyAccountPage();
        page.submitRemoveWishlistButton();
        }
    }

