package ui.pages.authentication;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import ui.pages.main.MyAccountPage;

/**
 * The class describes the page for creating and registering a new account.
 */
public class CreateAccountPage extends BasePage {

    @FindBy(id = "id_gender1")
    private WebElement mister;

    @FindBy(id = "id_gender2")
    private WebElement missis;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstname;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement day;

    @FindBy(id = "months")
    private WebElement month;

    @FindBy(id = "years")
    private WebElement year;

    @FindBy(id = "newsletter")
    private WebElement checkBox;

    @FindBy(id = "optin")
    private WebElement optin;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company
            ;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "address2")
    private WebElement address2;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "other")
    private WebElement other;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobile;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(css = "#submitAccount > span")
    private WebElement submitRegisterButton;

    public CreateAccountPage() {
        super();
    }

    @Step("Gender men is {0}.")
    public void isMister(boolean gender) {
        (gender ? mister : missis).click();
    }

    @Step("Enter customer first name {0}.")
    public void enterCustomerFirstName(String customerFirstName) {
        customerFirstname.sendKeys(customerFirstName);
    }

    @Step("Enter customer last name {0}.")
    public void enterCustomerLastName(String customerLastName) {
        customerLastname.sendKeys(customerLastName);
    }

    @Step("Enter password {0}.")
    public void enterPassword(String passw) {
        password.sendKeys(passw);
    }

    @Step("Enter birthday day {0}.")
    public void enterBirthdayDay(String days) {
        day.sendKeys(days);
    }

    @Step("Enter birthday month {0}.")
    public void enterBirthdayMonth(String months) {
        month.sendKeys(months);
    }

    @Step("Enter birthday year {0}.")
    public void enterBirthdayYear(String years) {
        year.sendKeys(years);
    }

    @Step("Chose Sign up for our newsletter.")
    public void choseSignUpForOurNewsletter(boolean signUpGorOurNewsletter) {
        if (signUpGorOurNewsletter) {
            checkBox.click();
        }
    }

    @Step("Chose Receive special offers from our partners.")
    public void choseReceiveSpecialOffersFromOurPartners(boolean receiveSpecialOffersFromOurPartners) {
        if (receiveSpecialOffersFromOurPartners) {
            optin.click();
        }
    }

    @Step("Enter first name {0}.")
    public void enterFirstName(String first_name) {
        firstName.sendKeys(first_name);
    }

    @Step("Enter first name {0}.")
    public void enterLastName(String last_name) {
        lastName.sendKeys(last_name);
    }

    @Step("Enter company name {0}.")
    public void enterCompanyName(String company_name) {
        company.sendKeys(company_name);
    }

    @Step("Enter address 1 {0}.")
    public void enterAdress1(String address_1) {
        address1.sendKeys(address_1);
    }

    @Step("Enter address 2 {0}.")
    public void enterAdress2(String address_2) {
        address2.sendKeys(address_2);
    }

    @Step("Enter city name {0}.")
    public void enterCityName(String city_name) {
        city.sendKeys(city_name);
    }

    @Step("Enter country {0}.")
    public void enterCountry(String country_name) {
        country.sendKeys(country_name);
    }

    @Step("Enter state name {0}.")
    public void enterStateName(String state_name) {
        state.sendKeys(state_name);
    }

    @Step("Enter postcode {0}.")
    public void enterPostcode(String postcode_number) {
        postcode.sendKeys(postcode_number);
    }

    @Step("Enter additional information {0}.")
    public void enterOther(String additionalInformation) {
        other.sendKeys(additionalInformation);
    }

    @Step("Enter phone number {0}.")
    public void enterHomePhoneNumber(String phone_number) {
        phone.sendKeys(phone_number);
    }

    @Step("Enter mobile phone number {0}.")
    public void enterMobilePhoneNumber(String phone_mobile_number) {
        phoneMobile.sendKeys(phone_mobile_number);
    }

    @Step("Enter assign an address alias for future reference. {0}.")
    public void enterAlias(String alias_name) {
        alias.sendKeys(alias_name);
    }

    @Step("Account registration {0}.")
    public MyAccountPage register() {
        submitRegisterButton.click();
        return new MyAccountPage();
    }
    @Step("Enter email {0}.")
    public void enterEmail(String emails) {
         email.sendKeys(emails);
    }
}
