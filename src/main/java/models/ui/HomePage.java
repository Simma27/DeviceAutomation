package models.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(linkText = "Sign in")
    private WebElement submitSignInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to auntefication page")
    public AuthenficationPage signIn() {
        submitSignInButton.click();
        return new AuthenficationPage(driver);
    }

}
