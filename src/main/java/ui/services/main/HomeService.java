package ui.services.main;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.interactions.Actions;
import ui.models.Clothes;
import ui.pages.main.HomePage;
import ui.pages.main.MyAccountPage;

import static ui.providers.DriverProvider.getDriver;

/**
 * Class provide methods to work with My Account page.
 */
@Log4j2
public class HomeService {

    /**
     * The method switch to Authentication page.
     */
    @Step("Press sign in button.")
    public static void signIn() {
        log.info("Press sign in button.");
        HomePage homePage = new HomePage();
        homePage.signIn();
    }

    /**
     * The method switch to Contact us page.
     */
    @Step("Press Contact us button.")
    public static void submitContactUs() {
        log.info("Press Contact us button.");
        HomePage homePage = new HomePage();
        homePage.contactUs();
    }

    /**
     * The method switch to My account page.
     */
    @Step("Press My account button.")
    public static MyAccountPage submitMyAccount() {
        log.info("Press My account button.");
        HomePage homePage = new HomePage();
        return homePage.submitAccountButton();
    }
    /**
     * The method switch to Summer dress page.
     */
    @Step("Choose {0}")
    public static void chooseClothes(Clothes clothes) {
        log.info("Choose clothes");
        HomePage homePage = new HomePage();
        homePage.moveToWomenButton();
        getDriver().findElement(clothes.getSelector()).click();
    }

}
