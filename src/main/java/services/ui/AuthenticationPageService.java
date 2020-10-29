package services.ui;

import pages.AuthenticationPage;


/**
 * Class provide methods to work with Authentication Page.
 */
public class AuthenticationPageService {
    /**
     * Method to create a new account and switch to CreateAccountPage.
     *
     * @param accountEmail is email address for new account.
     */
    public static void initiationСreateNewAccount(String accountEmail) {
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.enterAccountName(accountEmail);
        authenticationPage.submitCreateNewAccount();
    }

    public static void logIn(String emailAddress, String password) {
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.enterEmailAddress(emailAddress);
        authenticationPage.enterPassword(password);
        authenticationPage.submitSignIn();
    }

}
