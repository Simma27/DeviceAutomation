package models.ui;

import io.qameta.allure.Step;
import models.ui.providers.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

/**
 * Site home page.
 * http://automationpractice.com/index.php
 */
public class HomePage extends BasePage {

    @FindBy(linkText = "Sign in")
    private WebElement submitSignInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to auntefication page")
    public AuthenticationPage signIn() {
        submitSignInButton.click();
        return new AuthenticationPage(DriverProvider.getDriver());
    }

}
