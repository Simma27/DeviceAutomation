package services.ui;

import org.openqa.selenium.interactions.Actions;
import pages.HomePage;

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
}
