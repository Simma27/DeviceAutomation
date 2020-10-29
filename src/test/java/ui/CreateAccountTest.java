package ui;

import io.qameta.allure.Story;
import models.ui.PersonalInformation;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.PaymentPage;
import services.ui.AddressesPageService;
import services.ui.ShoppingCartSummaryPageService;

import static config.ui.AccountData.EMAIL_ADDRESS;
import static config.ui.AccountData.PASSWORD_EMAIL;
import static services.ui.AuthenticationPageService.initiationСreateNewAccount;
import static services.ui.AuthenticationPageService.logIn;
import static services.ui.CatalogPageService.goToPurchase;
import static services.ui.CreateAccountPageService.registrationNewAccount;
import static services.ui.HomePageService.sighIn;
import static services.ui.HomePageService.submitCasualDresses;
import static services.ui.PaymentPageService.registrationOfPurchase;
import static services.ui.ShippingPageService.delivery;

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
        ShoppingCartSummaryPageService.submitProceedToCheckoutButton();
        AddressesPageService.submitProceedToCheckoutButton();
        delivery();
        PaymentPage page = registrationOfPurchase();

        Assert.assertEquals(page.getOrderResult(), "Your order on My Store is complete.");
        Assert.assertEquals(page.getMessage(), "Your order will be sent as soon as we receive payment.");
    }

    public void sendEmailToCustomerService() {
//        WebDriver driver;
//        driver.findElement(By.cssSelector("#contact-link > a:nth-child(1)")).click();
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.id("id_contact"))).doubleClick()
//                .moveToElement(driver.findElement(By.cssSelector("#id_contact > option:nth-child(2)"))).click()
//                .build().perform();
//        actions.moveToElement(driver.findElement(By.id("id_order"))).doubleClick()
//                .moveToElement(driver.findElement(By.cssSelector("div.form-group:nth-child(6) > div:nth-child(2) > select:nth-child(2) > option:nth-child(2)"))).click()
//                .build().perform();
//        actions.moveToElement(driver.findElement(By.name("id_product"))).doubleClick()
//                .moveToElement(driver.findElement(By.cssSelector("/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div[1]/div[3]/div[1]/select/option[2]"))).click()
//                .build().perform();
//        driver.findElement(By.id("message")).sendKeys("I have a problem with my order. Could you help me?");
//        driver.findElement(By.cssSelector("#submitMessage > span:nth-child(1)")).click();
//        Assert.assertTrue(driver.findElement(By.cssSelector(".alert")).getText().equals("Your message has been successfully sent to our team."));
    }

    

}