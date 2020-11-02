package ui.pages.main;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.authentication.AuthenticationPage;
import ui.pages.product.CatalogPage;

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
    private WebElement tshirtButton;
    @FindBy(css = "[title='Women']")
    private WebElement womenButton;
    @FindBy(css = "[title='Blouses']")
    private WebElement blouseButton;
    @FindBy(css = ".account")
    private WebElement accountButton;

    public CatalogPage submitTshirtButton() {
        tshirtButton.click();
        return new CatalogPage();
    }

    @Step
    public CatalogPage submitCasualDresses() {
        casualDressesButton.click();
        return new CatalogPage();
    }

    public WebElement getDressesButton() {
        return dressesButton;
    }

    public WebElement getCasualDressesButton() {
        return casualDressesButton;
    }

    @Step("Navigate to auntefication page")
    public AuthenticationPage signIn() {
        submitSignInButton.click();
        return new AuthenticationPage();
    }

    @Step
    public void contactUs() {
        contactUsButton.click();
    }

    public WebElement getWomenButton() {
        return womenButton;
    }

    public WebElement getBlouseButton() {
        return blouseButton;
    }

    public MyAccountPage submitAccountButton() {
        accountButton.click();
        return new MyAccountPage();
    }

    public WebElement getSummerDressesButton() {
        return summerDressesButton;
    }

}
