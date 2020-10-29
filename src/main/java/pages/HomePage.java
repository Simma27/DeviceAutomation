package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(css = "[title='Contact Us']")
    private WebElement contactUsButton;

    @Step
    public CatalogPage submitCasualDresses () {
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



}
