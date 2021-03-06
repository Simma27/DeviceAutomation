package ui;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.models.Clothes;
import ui.models.PersonalInformation;
import ui.pages.main.ContactUsPage;
import ui.pages.main.MyAccountPage;
import ui.pages.payment.PaymentPage;
import ui.pages.product.BlousePage;
import ui.pages.product.FadedShortSleeveTshirtsPage;
import ui.pages.product.PrintedSummerDressPage;

import static ui.models.Colour.*;
import static ui.pages.product.PrintedSummerDressPage.chooseDressColour;
import static ui.services.authentication.AuthenticationService.createNewAccount;
import static ui.services.authentication.AuthenticationService.logIn;
import static ui.services.main.ContactUsService.sendMessage;
import static ui.services.main.HomeService.chooseClothes;
import static ui.services.main.MyAccountService.getWishlist;
import static ui.services.main.MyAccountService.removeWishlist;
import static ui.services.payment.PaymentService.registrationOfPurchase;
import static ui.services.product.BlouseService.addToWishList;
import static ui.services.product.BlouseService.quitMessage;
import static ui.services.product.CatalogService.goToBlousePage;
import static ui.services.product.FadedShortSleeveTshirtsService.writeReview;
import static ui.services.product.SummerDressesService.goToPrintedSummerDressPage;

@Epic("Automation practice site test")
public class AutomationPracticeSiteTest extends BaseTest {

    public static final String EMAIL_ADDRESS = "email@mail.com";
    public static final String PASSWORD_EMAIL = "12345";

    @Test(dataProvider = "getPersonalInformation", dataProviderClass = AutomationPracticeDataProvider.class)
    @Story("Create new account")
    @Description("Check possibility to create new account")
    @Severity(SeverityLevel.CRITICAL)
    public void newAccountTest(PersonalInformation personalInformation) {

        MyAccountPage page = createNewAccount(personalInformation);

        Assert.assertEquals(page.getTitle(), "My account - My Store");
        Assert.assertEquals(page.getCurrentURL(),
                "http://automationpractice.com/index.php?controller=my-account");
        Assert.assertTrue(page.topOfTheScreenBannerIsDisplayed());
        Assert.assertTrue(page.mainLogoIsDisplayed());
        Assert.assertTrue(page.searchBoxIsDisplayed());
        Assert.assertTrue(page.myAccountLogoIsDisplayed());
        Assert.assertTrue(page.menuLineIsDisplayed());
        Assert.assertTrue(page.navigationIsDisplayed());
        Assert.assertEquals(page.getPhoneNumber(), "0123-456-789");
        Assert.assertEquals(page.getInfoText(),
                "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @Test
    @Story("Order Evening Casual dress")
    @Description("Check the possibility to order Casual dress by bank wire")
    @Severity(SeverityLevel.CRITICAL)
    public void orderCasualDressTest() {

        logIn(EMAIL_ADDRESS, PASSWORD_EMAIL);
        chooseClothes(Clothes.CASUAL_DRESSES);
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
    public void sendEmailToCustomerService(PersonalInformation personalInformation) {
        createNewAccount(personalInformation);
        chooseClothes(Clothes.CASUAL_DRESSES);
        registrationOfPurchase();
        ContactUsPage contactUsPage = sendMessage();

        Assert.assertEquals(contactUsPage.getResultMessage(),
                "Your message has been successfully sent to our team.");
    }

    @Test
    @Story("Write review about product")
    @Description("Check the possibility to write review about 'Faded Short Sleeve T-shirts'")
    @Severity(SeverityLevel.MINOR)
    public void writeReviewTest() {
        int stars = 5;
        String title = "High quality product";
        String comment = "Faded short sleeve t-shirt with high neckline. " +
                "Soft and stretchy material for a comfortable fit. " +
                "Accessorize with a straw hat and you're ready for summer!";
        logIn(EMAIL_ADDRESS, PASSWORD_EMAIL);
        chooseClothes(Clothes.T_SHIRTS);
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
        logIn(EMAIL_ADDRESS, PASSWORD_EMAIL);
        goToBlousePage();
        BlousePage blousePage = addToWishList();
        Assert.assertEquals(blousePage.getResultMessage(), "Added to your wishlist.");
        quitMessage();
        MyAccountPage page = getWishlist();

        Assert.assertEquals(page.getProductName(), "Blouse\n" +
                "S, Black");
        Assert.assertEquals(page.getQuantity(), "1");
        Assert.assertEquals(page.getPriority(),
                ("                                                Medium\n" +
                        "                                            "));
        removeWishlist();
    }

    @Test
    @Story("Choose printed summer dress different colour")
    @Description("Check the possibility Printed Summer Dress page display for different colour dress")
    @Severity(SeverityLevel.NORMAL)
    public void differentColourPrintedSummerDressPageTest() {
        String attribute = "src";
        goToPrintedSummerDressPage();
        PrintedSummerDressPage page = chooseDressColour(BLACK);

        Assert.assertEquals(page.getAttributeBigPicture(attribute),
                "http://automationpractice.com/img/p/1/5/15-large_default.jpg");
        Assert.assertTrue(page.isDisplayedBigPicture());
        chooseDressColour(ORANGE);
        Assert.assertEquals(page.getAttributeBigPicture(attribute),
                "http://automationpractice.com/img/p/1/4/14-large_default.jpg");
        Assert.assertTrue(page.isDisplayedBigPicture());
        chooseDressColour(BLUE);
        Assert.assertEquals(page.getAttributeBigPicture(attribute),
                "http://automationpractice.com/img/p/1/3/13-large_default.jpg");
        Assert.assertTrue(page.isDisplayedBigPicture());
        chooseDressColour(YELLOW);
        Assert.assertEquals(page.getAttributeBigPicture(attribute),
                "http://automationpractice.com/img/p/1/2/12-large_default.jpg");
        Assert.assertTrue(page.isDisplayedBigPicture());
    }

}