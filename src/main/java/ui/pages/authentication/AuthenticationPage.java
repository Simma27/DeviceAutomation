package ui.pages.authentication;

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

    public void enterAccountName(String accountEmail) {
        newAccount.sendKeys(accountEmail);
    }

    public void enterEmailAddress(String emailAddress) {
        email.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        passwd.sendKeys(password);
    }

    public CreateAccountPage submitCreateNewAccount() {
        submitCreateAnAccountButton.click();
        return new CreateAccountPage();
    }

    public MyAccountPage submitSignIn() {
        signInButton.click();
        return new MyAccountPage();
    }


}