package ui;

import io.qameta.allure.*;
import ui.models.PersonalInformation;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.main.ContactUsPage;
import ui.pages.main.MyAccountPage;
import ui.pages.payment.PaymentPage;
import ui.pages.product.BlousePage;
import ui.pages.product.FadedShortSleeveTshirtsPage;
import ui.pages.product.PrintedSummerDressPage;
import ui.services.payment.AddressesPageService;
import ui.services.payment.ShoppingCartSummaryPageService;

import static ui.config.AccountData.EMAIL_ADDRESS;
import static ui.config.AccountData.PASSWORD_EMAIL;
import static ui.services.authentication.AuthenticationPageService.initiationСreateNewAccount;
import static ui.services.authentication.AuthenticationPageService.logIn;
import static ui.services.authentication.CreateAccountPageService.registrationNewAccount;
import static ui.services.main.ContactUsPageService.sendMessage;
import static ui.services.main.HomePageService.*;
import static ui.services.main.MyAccountPageService.getWishlist;
import static ui.services.main.MyAccountPageService.removeWishlist;
import static ui.services.payment.PaymentPageService.registrationOfPurchase;
import static ui.services.payment.ShippingPageService.delivery;
import static ui.services.product.BlousePageService.addToWishList;
import static ui.services.product.BlousePageService.quitMessage;
import static ui.services.product.CatalogPageService.*;
import static ui.services.product.FadedShortSleeveTshirtsPageService.writeReview;
import static ui.services.product.PrintedSummerDressPageService.*;
import static ui.services.product.SummerDressesPageService.goToPrintedSummerDress;

@Epic("Automation practice site test")
@Test(threadPoolSize = 6, invocationCount = 6)
public class AutomationPracticeSiteTest extends BaseTest {

    @Test(dataProvider = "getPersonalInformation", dataProviderClass = AutomationPracticeDataProvider.class)
    @Story("Create new account")
    @Description("Check possibility to create new account")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    public void newAccountTest(PersonalInformation personalInformation, String accountName) {

        sighIn();
        initiationСreateNewAccount(accountName);
        MyAccountPage myAccountPage = registrationNewAccount(personalInformation);

        Assert.assertEquals(myAccountPage.getTitle(), "My account - My Store");
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
    @Story("Order Evening Casual dress")
    @Description("Check the possibility to order Casual dress by bank wire")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    public void orderCasualDressTest() {
        sighIn();
        logIn(EMAIL_ADDRESS, PASSWORD_EMAIL);
        submitCasualDresses();
        goToPurchase();
        ShoppingCartSummaryPageService.submitProceedToCheckoutButton();
        AddressesPageService.submitProceedToCheckoutButton();
        delivery();
        PaymentPage page = registrationOfPurchase();

        Assert.assertEquals(page.getOrderResult(), "Your order on My Store is complete.");
        Assert.assertEquals(page.getMessage(), "Your order will be sent as soon as we receive payment.");
        Assert.assertEquals(page.getPrice(), "$28.00");
        Assert.assertEquals(page.getNameOfAccountOwner(), "Pradeep Macharla");
        Assert.assertEquals(page.getDetails(), "xyz");
        Assert.assertEquals(page.getBankName(), "RTP");
    }

    @Test(dataProvider = "getPersonalInformation", dataProviderClass = AutomationPracticeDataProvider.class)
    @Story("Send email to customer service")
    @Description("Check the possibility to send email to Customer Service")
    @Severity(SeverityLevel.NORMAL)
    @Flaky
    public void sendEmailToCustomerService(PersonalInformation personalInformation, String accountName) {
        sighIn();
        initiationСreateNewAccount(accountName);
        registrationNewAccount(personalInformation);
        submitCasualDresses();
        goToPurchase();
        ShoppingCartSummaryPageService.submitProceedToCheckoutButton();
        AddressesPageService.submitProceedToCheckoutButton();
        delivery();
        registrationOfPurchase();
        submitContactUs();
        ContactUsPage contactUsPage = sendMessage();

        Assert.assertEquals(contactUsPage.getResultMessage().getText(),
                "Your message has been successfully sent to our team.");
    }

    @Test
    @Story("Write review about product")
    @Description("Check the possibility to write review about 'Faded Short Sleeve T-shirts'")
    @Severity(SeverityLevel.MINOR)
    @Flaky
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
    @Story("Add blouse to wishlist")
    @Description("Check the possibility to add Blouse to wishlist")
    @Severity(SeverityLevel.MINOR)
    @Flaky
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
        removeWishlist();
    }

    @Test
    @Story("Choose printed summer dress different colour")
    @Description("Check the possibility Printed Summer Dress page display for different colour dress")
    @Severity(SeverityLevel.NORMAL)
    @Flaky
    public void differentColourPrintedSummerDressPageTest() {
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