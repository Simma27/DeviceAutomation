package ui.pages.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import ui.pages.authentication.AuthenticationPage;
import ui.pages.product.CatalogPage;

import static ui.providers.DriverProvider.getDriver;

/**
 * Site home page.
 * http://automationpractice.com/index.php
 */
public class HomePage extends BasePage {

    @FindBy(css = ".login")
    private WebElement submitSignInButton;

    @FindBy(css = ".sf-menu > li:nth-child(2) > a:nth-child(1)")
    private WebElement dressesButton;

    @FindBy(css = ".sf-menu > li:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")
    private WebElement casualDressesButton;

    @FindBy(css = ".sf-menu > li:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)")
    private WebElement summerDressesButton;

    @FindBy(css = "[title='Contact Us']")
    private WebElement contactUsButton;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    private WebElement tShirtButton;

    @FindBy(css = "[title='Women']")
    private WebElement womenButton;

    @FindBy(css = "[title='Blouses']")
    private WebElement blouseButton;

    @FindBy(css = ".account")
    private WebElement accountButton;

    public CatalogPage submitTshirtButton() {
        tShirtButton.click();
        return new CatalogPage();
    }

    public CatalogPage submitCasualDresses() {
        casualDressesButton.click();
        return new CatalogPage();
    }

    public AuthenticationPage signIn() {
        submitSignInButton.click();
        return new AuthenticationPage();
    }

    public void contactUs() {
        contactUsButton.click();
    }

    public void moveToWomenButton() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(womenButton)
                .build().perform();
    }

    public MyAccountPage submitAccountButton() {
        accountButton.click();
        return new MyAccountPage();
    }

}
