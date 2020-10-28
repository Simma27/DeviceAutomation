package services.ui;

import pages.AuthenticationPage;
import pages.HomePage;
import models.ui.providers.DriverProvider;

/**
 * Class provide methods to work with My Account page.
 */
public class HomePageService {
    /**
     * The method switch to Authentication page.
     *
     * @return the page following the home page for authentication.
     */
    public static AuthenticationPage sighIn() {
        HomePage homePage = new HomePage(DriverProvider.getDriver());
        return homePage.signIn();
    }
}
