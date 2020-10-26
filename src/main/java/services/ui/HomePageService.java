package services.ui;

import models.ui.AuthenticationPage;
import models.ui.HomePage;
import models.ui.model.DriverProvider;

/**
 * Class provide methods to work with My Account page.
 */
public class HomePageService {
    /**
     * The method switch to Authentication page.
     * @return the page following the home page for authentication.
     */
    public AuthenticationPage sighIn() {
        HomePage homePage = new HomePage(DriverProvider.getDriver());
        return homePage.signIn();
    }
}
