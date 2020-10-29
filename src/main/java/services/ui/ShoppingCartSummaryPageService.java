package services.ui;

import pages.ShoppingCartSummaryPage;

public class ShoppingCartSummaryPageService {

    public static void submitProceedToCheckoutButton() {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage();
        shoppingCartSummaryPage.getProceedToCheckoutButton().click();
    }
}
