package services.ui;

import models.ui.AuthenficationPage;
import models.ui.CreateAccountPage;
import models.ui.MyAccountPage;

public class ServiceUI {

    public CreateAccountPage createNewAccount(AuthenficationPage authenficationPage, String accountName) {
        authenficationPage.enterAccountName(accountName);
        return authenficationPage.submitCreateNewAccount();
    }

    public MyAccountPage fillPersonalInformation(CreateAccountPage accountPage, boolean isMister, String customer_firstname, String customer_lastname, String password, String day, String month, String year, boolean checkbox, boolean optin, String firstname, String lastname, String company, String address1, String address2, String city, String state, String postcode, String other, String phone, String phone_mobile, String alias) {
        accountPage.isMister(isMister);
        accountPage.enterCustomerFirstName(customer_firstname);
        accountPage.enterCustomerLastName(customer_lastname);
        accountPage.enterPassword(password);
        accountPage.enterBirthdayDay(day);
        accountPage.enterBirthdayMonth(month);
        accountPage.enterBirthdayYear(year);
        accountPage.choseSign_up_for_our_newsletter(checkbox);
        accountPage.choseReceive_special_offers_from_our_partners(optin);
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
        accountPage.enterPhoneMobileNumber(phone_mobile);
        accountPage.enterAlias(alias);
        return accountPage.register();
    }

}
