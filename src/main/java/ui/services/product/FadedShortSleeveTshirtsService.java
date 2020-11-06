package ui.services.product;

import io.qameta.allure.Step;
import ui.pages.product.FadedShortSleeveTshirtsPage;

import static ui.services.product.CatalogService.goToFadedShortSleeveTshirtsPage;

/**
 * The class consist of methods to work with Faded Short Sleeve T-shirts page.
 */
public class FadedShortSleeveTshirtsService {

    /**
     * The method fills in the review fields and sends it.
     * @param stars the number of stars of product quality from one to five.
     * @param title
     * @param comment
     * @return resulting messages of sending.
     */
    @Step("Write review.")
    public static FadedShortSleeveTshirtsPage writeReview(int stars, String title, String comment) {
        FadedShortSleeveTshirtsPage page = new FadedShortSleeveTshirtsPage();
        goToFadedShortSleeveTshirtsPage();
        page.submitWriteReviewButton();
        page.enterStarsQuality(stars);
        page.enterTitle(title);
        page.enterComment(comment);
        return page.submitSendButton();
    }
}
