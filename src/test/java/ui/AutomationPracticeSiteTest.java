package ui;

import io.qameta.allure.*;
import models.ui.PersonalInformation;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.main.ContactUsPage;
import pages.main.MyAccountPage;
import pages.payment.PaymentPage;
import pages.product.BlousePage;
import pages.product.FadedShortSleeveTshirtsPage;
import pages.product.PrintedSummerDressPage;
import providers.ScreenshotListener;
import services.ui.payment.AddressesPageService;
import services.ui.payment.ShoppingCartSummaryPageService;

import static config.ui.AccountData.EMAIL_ADDRESS;
import static config.ui.AccountData.PASSWORD_EMAIL;
import static services.ui.authentication.AuthenticationPageService.initiationСreateNewAccount;
import static services.ui.authentication.AuthenticationPageService.logIn;
import static services.ui.authentication.CreateAccountPageService.registrationNewAccount;
import static services.ui.main.ContactUsPageService.sendMessage;
import static services.ui.main.HomePageService.*;
import static services.ui.main.MyAccountPageService.getWishlist;
import static services.ui.main.MyAccountPageService.removeWishlist;
import static services.ui.payment.PaymentPageService.registrationOfPurchase;
import static services.ui.payment.ShippingPageService.delivery;
import static services.ui.product.BlousePageService.addToWishList;
import static services.ui.product.BlousePageService.quitMessage;
import static services.ui.product.CatalogPageService.*;
import static services.ui.product.FadedShortSleeveTshirtsPageService.writeReview;
import static services.ui.product.PrintedSummerDressPageService.*;
import static services.ui.product.SummerDressesPageService.goToPrintedSummerDress;

@Epic("Automationpractice site test")
@Listeners({ScreenshotListener.class})
public class AutomationPracticeSiteTest extends BaseTest {

    @Test(dataProvider = "getPersonalInformation", dataProviderClass = AutomationPracticeDataProvider.class, threadPoolSize = 3)
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

    @Test(threadPoolSize = 3)
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
    }

    @Test(dataProvider = "getPersonalInformation", dataProviderClass = AutomationPracticeDataProvider.class, threadPoolSize = 3)
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

    @Test(threadPoolSize = 5)
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

    @Test(threadPoolSize = 5)
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
    @Test(threadPoolSize = 5)
    @Story("Choose printed summer dress different colour")
    @Description("Check the possibility Printed Summer Dress page display for different colour dress")
    @Severity(SeverityLevel.NORMAL)
    @Flaky
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