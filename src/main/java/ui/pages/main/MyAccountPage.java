package ui.pages.main;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;

/**
 * Page for managing my account.
 */
public class MyAccountPage extends BasePage {

    @FindBy(css = ".img-responsive:nth-child(1)")
    private WebElement topOfTheScreenBanner;

    @FindBy(css = "[alt='My Store']")
    private WebElement mainLogoBanner;

    @FindBy(id = "searchbox")
    private WebElement searchBox;

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

    @FindBy(css = ".icon-heart")
    private WebElement myWishlistButton;

    @FindBy(css = ".table.table-bordered td a[onclick*='javascript:WishlistManage']:first-of-type")
    private WebElement getWishListButton;

    @FindBy(css = "#s_title")
    private WebElement productName;

    @FindBy(id = "quantity_2_7")
    private WebElement quantity;

    @FindBy(css = "#priority_2_7 > option:nth-child(2)")
    private WebElement priority;

    @FindBy(css = ".icon-remove-sign")
    private WebElement removeWishlistButton;

    @Step("Top of the screen banner is displayed")
    public boolean topOfTheScreenBannerIsDisplayed() {
        return topOfTheScreenBanner.isDisplayed();
    }

    @Step("Main logo is displayed")
    public boolean mainLogoIsDisplayed() {
        return mainLogoBanner.isDisplayed();
    }

    @Step("Searchbox is displayed")
    public boolean searchBoxIsDisplayed() {
        return searchBox.isDisplayed();
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


    public String getProductName() {
        return productName.getText();
    }

    public String getQuantity() {
        return quantity.getAttribute("value");
    }

    public String getPriority() {
        return priority.getText();
    }

    public void submitMyWishlistButton() {
        myWishlistButton.click();
    }

    public MyAccountPage submitGetwishlistButton() {
        getWishListButton.click();
        return new MyAccountPage();
    }

    public void submitRemoveWishlistButton() {
        removeWishlistButton.click();
    }

}
