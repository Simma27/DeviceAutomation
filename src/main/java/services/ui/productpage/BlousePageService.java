package services.ui.productpage;

import pages.BlousePage;

public class BlousePageService {

    public static BlousePage addToWishList() {
        BlousePage page = new BlousePage();
        return page.submitWishlistButton();
    }

    public static BlousePage quitMessage() {
        BlousePage page = new BlousePage();
        return page.submitQuitMessage();
    }
}
