package ui;

import io.qameta.allure.Story;
import models.ui.PersonalInformation;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import services.ui.paymentpage.PaymentPageService;

import static config.ui.AccountData.EMAIL_ADDRESS;
import static config.ui.AccountData.PASSWORD_EMAIL;
import static services.ui.ContactUsPageService.sendMessage;
import static services.ui.HomePageService.*;
import static services.ui.MyAccountPageService.getWishlist;
import static services.ui.authenticationpage.AuthenticationPageService.initiationСreateNewAccount;
import static services.ui.authenticationpage.AuthenticationPageService.logIn;
import static services.ui.authenticationpage.CreateAccountPageService.registrationNewAccount;
import static services.ui.paymentpage.PaymentPageService.ShippingPageService.delivery;
import static services.ui.paymentpage.PaymentPageService.registrationOfPurchase;
import static services.ui.productpage.BlousePageService.addToWishList;
import static services.ui.productpage.BlousePageService.quitMessage;
import static services.ui.productpage.CatalogPageService.*;
import static services.ui.productpage.FadedShortSleeveTshirtsPageService.writeReview;
import static services.ui.productpage.PrintedSummerDressPageService.*;
import static services.ui.productpage.SummerDressesPageService.goToPrintedSummerDress;

public class CreateAccountTest extends BaseTest {

    @Test
    @Story("UI test")
    public void newAccountTest() {
        //Parameters
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
        //Steps
        sighIn();
        initiationСreateNewAccount(accountName);
        MyAccountPage myAccountPage = registrationNewAccount(personalInformation);
        //Assertation
        Assert.assertEquals(myAccountPage.getTitle(),"My account - My Store" );
        Assert.assertEquals(myAccountPage.getCurrentURL(),
                "http://automationpractice.com/index.php?controller=my-account");
        Assert.assertTrue(myAccountPage.topOfTheScreenBannerIsDisplayed());
        Assert.assertTrue(myAccountPage.mainLogoIsDisplayed());
        Assert.assertTrue(myAccountPage.searchBoxIsDisplayed());
        Assert.assertTrue(myAccountPage.myAccountLogoIsDisplayed());
        Assert.assertTrue(myAccountPage.menuLineIsDisplayed());
        Assert.assertTrue(myAccountPage.navigationIsDisplayed());
        Assert.assertEquals(myAccountPage.getPhoneNumber(), "0123-456-789");
        Assert.assertEquals(myAccountPage.getInfoText(),
                "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @Test
    public void orderCasualDressTest() {

        sighIn();
        logIn(EMAIL_ADDRESS, PASSWORD_EMAIL);
        submitCasualDresses();
        goToPurchase();
        PaymentPageService.ShoppingCartSummaryPageService.submitProceedToCheckoutButton();
        PaymentPageService.AddressesPageService.submitProceedToCheckoutButton();
        delivery();
        PaymentPage page = registrationOfPurchase();

        Assert.assertEquals(page.getOrderResult(), "Your order on My Store is complete.");
        Assert.assertEquals(page.getMessage(), "Your order will be sent as soon as we receive payment.");
    }

    @Test
    public void sendEmailToCustomerService() {
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
        //Steps
        sighIn();
        initiationСreateNewAccount(accountName);
        registrationNewAccount(personalInformation);
        submitCasualDresses();
        goToPurchase();
        PaymentPageService.ShoppingCartSummaryPageService.submitProceedToCheckoutButton();
        PaymentPageService.AddressesPageService.submitProceedToCheckoutButton();
        delivery();
        registrationOfPurchase();
//        sighIn();
//        logIn(EMAIL_ADDRESS, PASSWORD_EMAIL);
        submitContactUs();
        ContactUsPage contactUsPage = sendMessage();
        Assert.assertEquals(contactUsPage.getResultMessage().getText(),
                "Your message has been successfully sent to our team.");
    }

    @Test
    public void writeReviewTest() {
        int stars = 5;
        String title = "High quality product";
        String comment = "Faded short sleeve t-shirt with high neckline. " +
                "Soft and stretchy material for a comfortable fit. " +
                "Accessorize with a straw hat and you're ready for summer!";
        sighIn();
        logIn(EMAIL_ADDRESS, PASSWORD_EMAIL);
        submitTshirt();
        goToFadedShortSleeveTshirtsPage();
        FadedShortSleeveTshirtsPage page = writeReview(stars, title, comment);

        Assert.assertEquals(page.getResultMessage(),
                "Your comment has been added and will be available once approved by a moderator");
    }

    @Test
    public void addBlouseToWishlist() {
        sighIn();
        logIn(EMAIL_ADDRESS, PASSWORD_EMAIL);
        submitBlouses();
        goToBlousePage();
        BlousePage page = addToWishList();
        Assert.assertEquals(page.getResultMessage(), "Added to your wishlist.");
        quitMessage();
        submitMyAccount();
        MyAccountPage myAccountPage = getWishlist();
        Assert.assertEquals(myAccountPage.getProductName(), "Blouse\n" +
                "S, Black");
        Assert.assertEquals(myAccountPage.getQuantity(), "1");
        Assert.assertEquals(myAccountPage.getPriority(),
                ("                                                Medium\n" +
                "                                            "));

    }

    @Test
    public void printedSummerDressPageTest() {
        submitSummerDresses();
        goToPrintedSummerDress();
        PrintedSummerDressPage page = chooseBlackColour();
        Assert.assertEquals(page.getBigPicture().getAttribute("src"),
                "http://automationpractice.com/img/p/1/5/15-large_default.jpg");
        Assert.assertTrue(page.getBigPicture().isDisplayed());
        chooseOrangeColour();
        Assert.assertEquals(page.getBigPicture().getAttribute("src"),
                "http://automationpractice.com/img/p/1/4/14-large_default.jpg");
        Assert.assertTrue(page.getBigPicture().isDisplayed());
        chooseBlueColour();
        Assert.assertEquals(page.getBigPicture().getAttribute("src"),
                "http://automationpractice.com/img/p/1/3/13-large_default.jpg");
        Assert.assertTrue(page.getBigPicture().isDisplayed());
        chooseYellowColour();
        Assert.assertEquals(page.getBigPicture().getAttribute("src"),
                "http://automationpractice.com/img/p/1/2/12-large_default.jpg");
        Assert.assertTrue(page.getBigPicture().isDisplayed());
    }

}