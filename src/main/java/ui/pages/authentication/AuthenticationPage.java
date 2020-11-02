package ui.pages.authentication;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import ui.pages.main.MyAccountPage;

/**
 * The page where you can create an account or log in with an existing one.
 */
public class AuthenticationPage extends BasePage {

    @FindBy(id = "email_create")
    private WebElement newAccount;

    @FindBy(css = "#SubmitCreate > span")
    private WebElement submitCreateAnAccountButton;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(css = "#SubmitLogin > span")
    private WebElement signInButton;

    public AuthenticationPage() {
        super();
    }

    /**
     *
     * @param accountEmail
     */
    @Step("Enter account email")
    public void enterAccountName(String accountEmail) {
        newAccount.sendKeys(accountEmail);
    }

    @Step
    public void enterEmailAddress(String emailAddress) {
        email.sendKeys(emailAddress);
    }

    @Step
    public void enterPassword(String password) {
        passwd.sendKeys(password);
    }

    @Step("Create new account")
    public CreateAccountPage submitCreateNewAccount() {
        submitCreateAnAccountButton.click();
        return new CreateAccountPage();
    }

    @Step("Log in")
    public MyAccountPage submitSignIn() {
        signInButton.click();
        return new MyAccountPage();
    }


}