package services.ui;

import models.ui.providers.DriverProvider;
import pages.HomePage;

/**
 * Class provide methods to work with My Account page.
 */
public class HomePageService {
    /**
     * The method switch to Authentication page.
     */
    public static void sighIn() {
        HomePage homePage = new HomePage(DriverProvider.getDriver());
        homePage.signIn();
    }
}
