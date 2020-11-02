package ui;

import models.ui.PersonalInformation;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.DataProvider;

public class AutomationPracticeDataProvider {

    @DataProvider(parallel = true)
    public Object[][] getPersonalInformation() {
        return new Object[][]{{new PersonalInformation.Builder()
                .withGender(true)
                .withCustomerFirstName("Ivan")
                .withCustomerLastName("Ivanov")
                .withPassword("11111")
                .withBirthdayDay("1")
                .withBirthdayMonth("January")
                .withBirthdayYear("2020")
                .withSignUpForOurNewsletter(true)
                .withReceiveSpecialOffersFromOurPartners(true)
                .withCompany("Kaseya")
                .withAddress1("701 Brickell Avenue")
                .withAddress2("26 W 17th Street, New York")
                .withCity("Miami")
                .withState("Florida")
                .withPostcode("33131")
                .withAdditionalInformation("Additional information")
                .withHomePhoneNumber("+375441111111")
                .withMobilePhoneNumber("+375292222222")
                .withAlias("18, Baker street")
                .build(), RandomString.make(5)}
        };
    }
}
