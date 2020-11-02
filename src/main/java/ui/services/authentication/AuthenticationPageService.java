package ui.services.authentication;

import io.qameta.allure.Step;
import ui.models.PersonalInformation;
import ui.pages.authentication.AuthenticationPage;
import ui.pages.main.MyAccountPage;

import static ui.services.authentication.CreateAccountPageService.registrationNewAccount;
import static ui.services.main.HomePageService.signIn;


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
        signIn();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.enterEmailAddress(emailAddress);
        authenticationPage.enterPassword(password);
        authenticationPage.submitSignIn();
    }

    public static MyAccountPage createNewAccount(PersonalInformation personalInformation) {
        signIn();
        initiationСreateNewAccount(personalInformation.getEmail());
        return registrationNewAccount(personalInformation);
    }

}
