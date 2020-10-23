package models.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenficationPage extends PageObject {

     @FindBy(id="email_create")
     private WebElement newAccount;
     @FindBy(css = "#SubmitCreate > span" )
     private WebElement submitCreateAnAccountButton;

    public void enterAccountName(String accountName) {
        newAccount.clear();
        newAccount.sendKeys(accountName + "@gmail.com");
    }

    public CreateAccountPage submitCreateNewAccount() {
        submitCreateAnAccountButton.click();
        return new CreateAccountPage(driver);
    }

    public AuthenficationPage(WebDriver driver) {
        super(driver);
    }

}