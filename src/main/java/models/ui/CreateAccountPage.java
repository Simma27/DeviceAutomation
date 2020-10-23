package models.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageObject {

    @FindBy(id="id_gender1")
    private WebElement mister;
    @FindBy(id="id_gender2")
    private WebElement missis;
    @FindBy(id = "customer_firstname")
    private WebElement customer_firstname;
    @FindBy(id = "customer_lastname")
    private WebElement customer_lastname;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(id = "days")
    private WebElement day;
    @FindBy(id = "months")
    private WebElement month;
    @FindBy(id = "years")
    private WebElement year;
    @FindBy(css = "[type='checkbox']")
    private WebElement checkbox;
    @FindBy(id = "optin")
    private WebElement optin;
    @FindBy(id = "firstname")
    private WebElement firstname;
    @FindBy(id = "lastname")
    private WebElement lastname;
    @FindBy(id = "company")
    private WebElement company;
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
    private WebElement phone_mobile;
    @FindBy(id = "alias")
    private WebElement alias;
    @FindBy(css = "#submitAccount > span")
    private WebElement submitRegisterButton;
    @Step("Gender men is {0}.")
    public void isMister(boolean gender){
        (gender ? mister : missis).click();
    }
    @Step("Enter customer first name {0}.")
    public void enterCustomerFirstName(String customerFirstName) {
        customer_firstname.sendKeys(customerFirstName);
    }
    @Step("Enter customer last name {0}.")
    public void enterCustomerLastName(String customerLastName) {
        customer_lastname.sendKeys(customerLastName);
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
    public void choseSign_up_for_our_newsletter() {
        checkbox.click();
    }
    @Step("Chose Receive special offers from our partners.")
    public void choseReceive_special_offers_from_our_partners() {
        optin.click();
    }
    @Step("Enter first name {0}.")
    public void enterFirstName(String first_name) {
        firstname.sendKeys(first_name);
    }
    @Step("Enter first name {0}.")
    public void enterLastName(String last_name) {
        lastname.sendKeys(last_name);
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
    public void enterPhoneNumber(String phone_number) {
        phone.sendKeys(phone_number);
    }
    @Step("Enter mobile phone number {0}.")
    public void enterPhoneMobileNumber(String phone_mobile_number) {
        phone_mobile.sendKeys(phone_mobile_number);
    }
    @Step("Enter assign an address alias for future reference. {0}.")
    public void enterAlias(String alias_name) {
        alias.sendKeys(alias_name);
    }
    @Step("Account registration {0}.")
    public MyAccountPage register(){
        submitRegisterButton.click();
        return new MyAccountPage();
    }

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }
}
