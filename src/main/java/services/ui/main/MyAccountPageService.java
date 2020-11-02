package services.ui.main;

import io.qameta.allure.Step;
import pages.main.MyAccountPage;

/**
 * Class consist of methods to work with "Me account" page
 */
public class MyAccountPageService {
    @Step
    public static MyAccountPage getWishlist() {
        MyAccountPage page = new MyAccountPage();
        page.submitMyWishlistButton();
        return page.submitGetwishlistButton();
    }
    @Step
    public static void removeWishlist() {
        MyAccountPage page = new MyAccountPage();
        page.submitRemoveWishlistButton();
        }
    }

