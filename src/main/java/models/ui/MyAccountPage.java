package models.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject {

    @FindBy(css = ".img-responsive:nth-child(1)")
    private WebElement top_of_the_screen_banner;
    @FindBy(css = "[alt='My Store']")
    private WebElement main_logo_banner;
    @FindBy(css = "#searchbox")
    private WebElement searchbox;
    @FindBy(css = ".page-heading")
    private WebElement my_account_logo;
    @FindBy(css = ".nav")
    private WebElement menu_line;
    @FindBy(css = ".shop-phone > strong")
    private WebElement phone_number;
    @FindBy(css = ".navigation_page")
    private WebElement navigation_page;
    @FindBy(css = ".info-account")
    private WebElement info;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Top of the screen banner is displayed")
    public boolean top_of_the_screen_banner_is_displayed() {
        return top_of_the_screen_banner.isDisplayed();
    }

    @Step("Main logo is displayed")
    public boolean main_logo_is_displayed() {
        return main_logo_banner.isDisplayed();
    }

    @Step("My account logo is displayed")
    public boolean my_account_logo_is_displayed() {
        return my_account_logo.isDisplayed();
    }

    @Step("Get internet shop phone number")
    public String getPhoneNumber() {
        return phone_number.getText();
    }

    @Step("Navigation page is displayed")
    public boolean navigation_is_displayed() {
        return navigation_page.isDisplayed();
    }

    @Step("Get info from page")
    public String getInfoText() {
        return info.getText();
    }

}
