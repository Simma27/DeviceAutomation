package services.ui.main;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import pages.main.HomePage;
import pages.main.MyAccountPage;

import static pages.main.BasePage.getDriver;

/**
 * Class provide methods to work with My Account page.
 */
public class HomePageService {

    /**
     * The method switch to Authentication page.
     */
    @Step
    public static void sighIn() {
        HomePage homePage = new HomePage();
        homePage.signIn();
    }

    /**
     * The method switch to Evening Casual Dress page.
     */
    @Step
    public static void submitCasualDresses() {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(homePage.getDressesButton())
                .moveToElement(homePage.getCasualDressesButton()).click()
                .build().perform();
    }
    /**
     * The method switch to Contact us page.
     */
    @Step
    public static void submitContactUs() {
        HomePage homePage = new HomePage();
        homePage.contactUs();
    }
    /**
     * The method switch to T-shirt page.
     */
    @Step
    public static void submitTshirt() {
        HomePage homePage = new HomePage();
        homePage.submitTshirtButton();
    }
    /**
     * The method switch to Blouse page.
     */
    @Step
    public static void submitBlouses() {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(homePage.getWomenButton())
                .click(homePage.getBlouseButton())
                .build().perform();
    }
    /**
     * The method switch to My account page.
     */
    @Step
    public static MyAccountPage submitMyAccount() {
        HomePage homePage = new HomePage();
        return homePage.submitAccountButton();
    }
    /**
     * The method switch to Summer dress page.
     */
    @Step
    public static void submitSummerDresses() {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(homePage.getDressesButton())
                .click(homePage.getSummerDressesButton())
                .build().perform();
    }

}
