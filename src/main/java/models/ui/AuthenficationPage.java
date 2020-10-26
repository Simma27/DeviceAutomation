package models.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The page where you can create an account or log in with an existing one.
 */
public class AuthenficationPage extends PageObject {

    @FindBy(id = "email_create")
    private WebElement newAccount;
    @FindBy(css = "#SubmitCreate > span")
    private WebElement submitCreateAnAccountButton;

    public AuthenficationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter account name")
    public void enterAccountName(String accountName) {
        newAccount.clear();
        newAccount.sendKeys(accountName + "@gmail.com");
    }

    @Step("Create new account")
    public CreateAccountPage submitCreateNewAccount() {
        submitCreateAnAccountButton.click();
        return new CreateAccountPage(driver);
    }

}