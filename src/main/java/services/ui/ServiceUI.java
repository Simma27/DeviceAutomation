package services.ui;

import models.ui.AuthenficationPage;
import models.ui.CreateAccountPage;
import models.ui.MyAccountPage;

/**
 * Сlass providing methods for UI testing
 */
public class ServiceUI {
    /*
     * Method to create a new account and switch to CreateAccountPage.
     * @param authenficationPage The page where you can create an account or log in with an existing one.
     * @param accountName is name new Account.
     * @return page next to home page when want to create new account.
     */
    public CreateAccountPage createNewAccount(AuthenficationPage authenficationPage, String accountName) {
        authenficationPage.enterAccountName(accountName);
        return authenficationPage.submitCreateNewAccount();
    }

    /*
     * Method to fill in profile data for a new account.
     * @param personal user data
     * @return MyAccountPage when page upon successful account creation
     */
    public MyAccountPage fillPersonalInformation(CreateAccountPage accountPage, boolean isMister,
           String customerFirstname, String customerLastname, String password, String day, String month, String year,
           boolean checkbox, boolean optin, String firstname, String lastname, String company, String address1,
           String address2, String city, String state, String postcode, String other, String phone, String phoneMobile,
           String alias) {
        accountPage.isMister(isMister);
        accountPage.enterCustomerFirstName(customerFirstname);
        accountPage.enterCustomerLastName(customerLastname);
        accountPage.enterPassword(password);
        accountPage.enterBirthdayDay(day);
        accountPage.enterBirthdayMonth(month);
        accountPage.enterBirthdayYear(year);
        accountPage.choseSignUpForOurNewsletter(checkbox);
        accountPage.choseReceiveSpecialOffersFromOurPartners(optin);
        accountPage.enterFirstName(firstname);
        accountPage.enterLastName(lastname);
        accountPage.enterCompanyName(company);
        accountPage.enterAdress1(address1);
        accountPage.enterAdress2(address2);
        accountPage.enterCityName(city);
        accountPage.enterStateName(state);
        accountPage.enterPostcode(postcode);
        accountPage.enterOther(other);
        accountPage.enterPhoneNumber(phone);
        accountPage.enterPhoneMobileNumber(phoneMobile);
        accountPage.enterAlias(alias);
        return accountPage.register();
    }

}
