package ui;

import models.ui.model.PersonalInformation;
import models.ui.providers.DriverProvider;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyAccountPage;

import static services.ui.AuthenticationPageService.initiationСreateNewAccount;
import static services.ui.CreateAccountPageService.registrationNewAccount;
import static services.ui.HomePageService.sighIn;

public class CreateAccountTest {


    @BeforeMethod
    public void setup() {
        DriverProvider.setUp();
    }

    @Test
    public void newAccountTest() {
        String accountName = RandomString.make(5);
        PersonalInformation personalInformation = new PersonalInformation.Builder()
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
                .build();
        // Is it possible to use static methods of the service?
        sighIn();
        initiationСreateNewAccount(accountName);
        MyAccountPage myAccountPage = registrationNewAccount(personalInformation);

        Assert.assertEquals(myAccountPage.getTitle(),"My account - My Store" );
        Assert.assertEquals(myAccountPage.getCurrentURL(),
                "http://automationpractice.com/index.php?controller=my-account");
        Assert.assertTrue(myAccountPage.topOfTheScreenBannerIsDisplayed());
        Assert.assertTrue(myAccountPage.mainLogoIsDisplayed());
        Assert.assertTrue(myAccountPage.searchboxIsDisplayed());
        Assert.assertTrue(myAccountPage.myAccountLogoIsDisplayed());
        Assert.assertTrue(myAccountPage.menuLineIsDisplayed());
        Assert.assertTrue(myAccountPage.navigationIsDisplayed());
        Assert.assertEquals(myAccountPage.getPhoneNumber(), "0123-456-789");
        Assert.assertEquals(myAccountPage.getInfoText(),
                "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @AfterMethod
    public void finish() {
        DriverProvider.tearDown();
    }

}