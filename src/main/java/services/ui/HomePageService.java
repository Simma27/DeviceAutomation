package services.ui;

import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.MyAccountPage;

import static providers.DriverProvider.getDriver;

/**
 * Class provide methods to work with My Account page.
 */
public class HomePageService {

    /**
     * The method switch to Authentication page.
     */
    public static void sighIn() {
        HomePage homePage = new HomePage();
        homePage.signIn();
    }

    public static void submitCasualDresses() {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(homePage.getDressesButton())
                .moveToElement(homePage.getCasualDressesButton()).click().build().perform();
    }

    public static void submitContactUs() {
        HomePage homePage = new HomePage();
        homePage.contactUs();
    }

    public static void submitTshirt() {
        HomePage homePage = new HomePage();
        homePage.submitTshirtButton();
    }

    public static void submitBlouses() {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(homePage.getWomenButton())
                .click(homePage.getBlouseButton())
                .build().perform();
    }

    public static MyAccountPage submitMyAccount() {
        HomePage homePage = new HomePage();
        return homePage.submitAccountButton();
    }

    public static void submitSummerDresses() {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(homePage.getDressesButton())
                .click(homePage.getSummerDressesButton())
                .build().perform();
    }

}
