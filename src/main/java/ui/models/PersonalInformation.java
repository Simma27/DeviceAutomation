package ui.models;

/**
 * Class describe model personal information when create new account.
 */
public class PersonalInformation {

    private boolean isMister;

    private String customerFirstname;

    private String customerLastname;

    private String email;

    private String password;

    private String day;

    private String month;

    private String year;

    private boolean signUpGorOurNewsletter;

    private boolean receiveSpecialOffersFromOurPartners;

    private String firstname;

    private String lastname;

    private String company;

    private String address1;

    private String address2;

    private String city;

    private String country;

    private String state;

    private String postcode;

    private String other;


    private String homePhone;

    private String mobilePhone;

    private String alias;

    public boolean isMister() {
        return isMister;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public String getEmail() { return email; }

    public String getPassword() {
        return password;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public boolean isSignUpGorOurNewsletter() {
        return signUpGorOurNewsletter;
    }

    public void setSignUpGorOurNewsletter(boolean signUpGorOurNewsletter) {
        this.signUpGorOurNewsletter = signUpGorOurNewsletter;
    }

    public boolean isReceiveSpecialOffersFromOurPartners() {
        return receiveSpecialOffersFromOurPartners;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getOther() {
        return other;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getPhoneMobile() {
        return mobilePhone;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "isMister=" + isMister +
                ", customerFirstname='" + customerFirstname + '\'' +
                ", customerLastname='" + customerLastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", signUpGorOurNewsletter=" + signUpGorOurNewsletter +
                ", receiveSpecialOffersFromOurPartners=" + receiveSpecialOffersFromOurPartners +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company='" + company + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", postcode='" + postcode + '\'' +
                ", other='" + other + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }

    public static class Builder {

        private PersonalInformation personalInformation;

        public Builder() {
            personalInformation = new PersonalInformation();
        }

        public Builder withGender(boolean isMister) {
            personalInformation.isMister = isMister;
            return this;
        }

        public Builder withCustomerFirstName(String customerFirstName) {
            personalInformation.customerFirstname = customerFirstName;
            return this;
        }

        public Builder withCustomerLastName(String customerLastName) {
            personalInformation.customerLastname = customerLastName;
            return this;
        }

        public Builder withEmail(String email) {
            personalInformation.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            personalInformation.password = password;
            return this;
        }

        public Builder withBirthdayDay(String birthdayDay) {
            personalInformation.day = birthdayDay;
            return this;
        }

        public Builder withBirthdayMonth(String birthdayMonth) {
            personalInformation.month = birthdayMonth;
            return this;
        }

        public Builder withBirthdayYear(String birthdayYear) {
            personalInformation.year = birthdayYear;
            return this;
        }

        public Builder withSignUpForOurNewsletter(boolean signUpForOurNewsletter) {
            personalInformation.signUpGorOurNewsletter = signUpForOurNewsletter;
            return this;
        }

        public Builder withReceiveSpecialOffersFromOurPartners(boolean receiveSpecialOffersFromOurPartners) {
            personalInformation.receiveSpecialOffersFromOurPartners = receiveSpecialOffersFromOurPartners;
            return this;
        }

        public Builder withFirstName(String firstName) {
            personalInformation.firstname = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            personalInformation.lastname = lastName;
            return this;
        }

        public Builder withCompany(String companyName) {
            personalInformation.company = companyName;
            return this;
        }

        public Builder withAddress1(String address1) {
            personalInformation.address1 = address1;
            return this;
        }

        public Builder withAddress2(String address2) {
            personalInformation.address2 = address2;
            return this;
        }

        public Builder withCity(String cityName) {
            personalInformation.city = cityName;
            return this;
        }

        public Builder withCountry(String countryName) {
            personalInformation.country = countryName;
            return this;
        }

        public Builder withState(String stateName) {
            personalInformation.state = stateName;
            return this;
        }

        public Builder withPostcode(String postcode) {
            personalInformation.postcode = postcode;
            return this;
        }

        public Builder withAdditionalInformation(String additionalInformation) {
            personalInformation.other = additionalInformation;
            return this;
        }

        public Builder withHomePhoneNumber(String homePhoneNumber) {
            personalInformation.homePhone = homePhoneNumber;
            return this;
        }

        public Builder withMobilePhoneNumber(String mobilePhoneNumber) {
            personalInformation.mobilePhone = mobilePhoneNumber;
            return this;
        }

        public Builder withAlias(String alias) {
            personalInformation.alias = alias;
            return this;
        }

        public PersonalInformation build() {
            return personalInformation;
        }
    }

}
