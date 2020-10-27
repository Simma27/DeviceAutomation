package services.ui;

import models.ui.AuthenticationPage;
import models.ui.providers.DriverProvider;


/**
 * Class provide methods to work with Authentication Page.
 */
public class AuthenticationPageService {

    /**
     * Method to create a new account and switch to CreateAccountPage.
     *
     * @param accountEmail is email address for new account.
     * @return the page following the Authentication page for create new account.
     */
    public void initiationСreateNewAccount(String accountEmail) {
        AuthenticationPage authenticationPage = new AuthenticationPage(DriverProvider.getDriver());
        authenticationPage.enterAccountName(accountEmail);
        authenticationPage.submitCreateNewAccount();
    }

}
