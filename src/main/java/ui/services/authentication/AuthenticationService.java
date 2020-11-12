package ui.services.authentication;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.models.PersonalInformation;
import ui.pages.authentication.AuthenticationPage;
import ui.pages.main.MyAccountPage;

import static ui.services.authentication.CreateAccountService.registrationNewAccount;
import static ui.services.main.HomeService.signIn;


/**
 * Class provide methods to work with Authentication Page.
 */
@Log4j2
public class AuthenticationService {
    /**
     * Method to create a new account and switch to CreateAccountPage.
     *
     * @param accountEmail is email address for new account.
     */
    @Step("Initiation create a new account.")
    public static void initiationСreateNewAccount(String accountEmail) {
        log.info("Step:Initiation create a new account, method: initiationСreateNewAccount(String accountEmail), " +
                "input parameter: " + accountEmail);
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
    @Step("Log in with email and password")
    public static void logIn(String emailAddress, String password) {
        log.info("Step: Log in with email and password, method: logIn(String emailAddress, String password), " +
                "input parameters: emailAddress " + emailAddress + "password: " + password);
        signIn();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.enterEmailAddress(emailAddress);
        authenticationPage.enterPassword(password);
        authenticationPage.submitSignIn();
    }

    /**
     * Create a new account.
     *
     * @param personalInformation is model with personal information for new account.
     */
    @Step("Create a new account")
    public static MyAccountPage createNewAccount(PersonalInformation personalInformation) {
        log.info("Step: Create a new account, method: initiationСreateNewAccount(String accountEmail), " +
                "input parameter: personalInformation " + personalInformation.toString());
        signIn();
        initiationСreateNewAccount(personalInformation.getEmail());
        return registrationNewAccount(personalInformation);
    }

}
