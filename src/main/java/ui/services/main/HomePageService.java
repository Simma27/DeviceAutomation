package ui.services.main;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import ui.providers.DriverProvider;
import ui.pages.main.HomePage;
import ui.pages.main.MyAccountPage;

/**
 * Class provide methods to work with My Account page.
 */
public class HomePageService {

    /**
     * The method switch to Authentication page.
     */
    @Step
    public static void signIn() {
        HomePage homePage = new HomePage();
        homePage.signIn();
    }

    /**
     * The method switch to Evening Casual Dress page.
     */
    @Step
    public static void chooseCasualDresses() {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(DriverProvider.getDriver());
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
    public static void chooseTshirt() {
        HomePage homePage = new HomePage();
        homePage.submitTshirtButton();
    }
    /**
     * The method switch to Blouse page.
     */
    @Step
    public static void chooseBlouses() {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(DriverProvider.getDriver());
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
    public static void chooseSummerDresses() {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(DriverProvider.getDriver());
        actions.moveToElement(homePage.getDressesButton())
                .click(homePage.getSummerDressesButton())
                .build().perform();
    }

}
