package ui.services.authentication;

import io.qameta.allure.Step;
import ui.pages.authentication.AuthenticationPage;


/**
 * Class provide methods to work with Authentication Page.
 */
public class AuthenticationPageService {
    /**
     * Method to create a new account and switch to CreateAccountPage.
     *
     * @param accountEmail is email address for new account.
     */
    @Step
    public static void initiationСreateNewAccount(String accountEmail) {
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.enterAccountName(accountEmail);
        authenticationPage.submitCreateNewAccount();
    }
    /**
     * Log in to automationpractice.com like user.
     *
     * @param emailAddress is existing email address.
     * @param password is password your account.
     */
    @Step
    public static void logIn(String emailAddress, String password) {
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.enterEmailAddress(emailAddress);
        authenticationPage.enterPassword(password);
        authenticationPage.submitSignIn();
    }

}
