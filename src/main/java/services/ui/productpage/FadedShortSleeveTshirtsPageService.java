package services.ui.productpage;

import pages.FadedShortSleeveTshirtsPage;

public class FadedShortSleeveTshirtsPageService {

    public static FadedShortSleeveTshirtsPage writeReview(int stars, String title, String comment) {
        FadedShortSleeveTshirtsPage page = new FadedShortSleeveTshirtsPage();
        page.submitWriteReviewButton();
        page.etnerStarsQuality(stars);
        page.enterTitle(title);
        page.enterComment(comment);
        return page.submitSendButton();
    }
}
