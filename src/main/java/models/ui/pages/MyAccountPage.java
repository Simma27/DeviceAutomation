package models.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page for managing my account.
 */
public class MyAccountPage extends BasePage {

    @FindBy(css = ".img-responsive:nth-child(1)")
    private WebElement topOfTheScreenBanner;
    @FindBy(css = "[alt='My Store']")
    private WebElement mainLogoBanner;
    @FindBy(css = "#searchbox")
    private WebElement searchbox;
    @FindBy(css = ".page-heading")
    private WebElement myAccountLogo;
    @FindBy(css = ".nav")
    private WebElement menuLine;
    @FindBy(css = ".shop-phone > strong")
    private WebElement phoneNumber;
    @FindBy(css = ".navigation_page")
    private WebElement navigationPage;
    @FindBy(css = ".info-account")
    private WebElement info;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Top of the screen banner is displayed")
    public boolean topOfTheScreenBannerIsDisplayed() {
        return topOfTheScreenBanner.isDisplayed();
    }

    @Step("Main logo is displayed")
    public boolean mainLogoIsDisplayed() {
        return mainLogoBanner.isDisplayed();
    }

    @Step("Searchbox is displayed")
    public boolean searchboxIsDisplayed() {
        return searchbox.isDisplayed();
    }

    @Step("My account logo is displayed")
    public boolean myAccountLogoIsDisplayed() {
        return myAccountLogo.isDisplayed();
    }

    @Step("Menu line is displayed")
    public boolean menuLineIsDisplayed() {
        return menuLine.isDisplayed();
    }

    @Step("Get internet shop phone number")
    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

    @Step("Navigation page is displayed")
    public boolean navigationIsDisplayed() {
        return navigationPage.isDisplayed();
    }

    @Step("Get info from page")
    public String getInfoText() {
        return info.getText();
    }

}
