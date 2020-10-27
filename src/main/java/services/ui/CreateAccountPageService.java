package services.ui;

import models.ui.pages.CreateAccountPage;
import models.ui.pages.MyAccountPage;
import models.ui.providers.DriverProvider;
import models.ui.model.PersonalInformation;

/**
 * Class provide methods to work with page "Create new an account".
 */
public class CreateAccountPageService {

    /**
     * The method fills in the profile data for a new account and registers the account.
     *
     * @param personalInformation is model with personal information for new account.
     * @return the page following the CreateAccountPage for managing my account.
     */
    public MyAccountPage registrationNewAccount(PersonalInformation personalInformation) {
        CreateAccountPage accountPage = new CreateAccountPage(DriverProvider.getDriver());
        accountPage.isMister(personalInformation.isMister());
        accountPage.enterCustomerFirstName(personalInformation.getCustomerFirstname());
        accountPage.enterCustomerLastName(personalInformation.getCustomerLastname());
        accountPage.enterPassword(personalInformation.getPassword());
        accountPage.enterBirthdayDay(personalInformation.getDay());
        accountPage.enterBirthdayMonth(personalInformation.getMonth());
        accountPage.enterBirthdayYear(personalInformation.getYear());
        accountPage.choseSignUpForOurNewsletter(personalInformation.isSignUpGorOurNewsletter());
        accountPage.choseReceiveSpecialOffersFromOurPartners(personalInformation.isReceiveSpecialOffersFromOurPartners());
        accountPage.enterFirstName(personalInformation.getFirstname());
        accountPage.enterLastName(personalInformation.getLastname());
        accountPage.enterCompanyName(personalInformation.getCompany());
        accountPage.enterAdress1(personalInformation.getAddress1());
        accountPage.enterAdress2(personalInformation.getAddress2());
        accountPage.enterCityName(personalInformation.getCity());
        accountPage.enterStateName(personalInformation.getState());
        accountPage.enterPostcode(personalInformation.getPostcode());
        accountPage.enterOther(personalInformation.getOther());
        accountPage.enterHomePhoneNumber(personalInformation.getHomePhone());
        accountPage.enterMobilePhoneNumber(personalInformation.getPhoneMobile());
        accountPage.enterAlias(personalInformation.getAlias());
        return accountPage.register();
    }

}
