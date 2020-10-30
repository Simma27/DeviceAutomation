package services.ui;

import pages.MyAccountPage;

public class MyAccountPageService {

    public static MyAccountPage getWishlist() {
        MyAccountPage page = new MyAccountPage();
        page.submitMyWishlistButton();
        return page.submitGetwishlistButton();
    }
}
