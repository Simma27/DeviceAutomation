package ui.services.main;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import ui.models.Clothes;
import ui.pages.main.HomePage;
import ui.pages.main.MyAccountPage;

import static ui.providers.DriverProvider.getDriver;

/**
 * Class provide methods to work with My Account page.
 */
public class HomePageService {

    /**
     * The method switch to Authentication page.
     */
    @Step("Press sign in button.")
    public static void signIn() {
        HomePage homePage = new HomePage();
        homePage.signIn();
    }

    /**
     * The method switch to Contact us page.
     */
    @Step("Press Contact us button.")
    public static void submitContactUs() {
        HomePage homePage = new HomePage();
        homePage.contactUs();
    }

    /**
     * The method switch to My account page.
     */
    @Step("Press My account button.")
    public static MyAccountPage submitMyAccount() {
        HomePage homePage = new HomePage();
        return homePage.submitAccountButton();
    }
    /**
     * The method switch to Summer dress page.
     */
    @Step("Choose {0}")
    public static void chooseClothes(Clothes clothes) {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(homePage.getWomenButton())
                .build().perform();
        getDriver().findElement(clothes.getSelector()).click();
    }

}
