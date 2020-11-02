package ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.main.BasePage;
import ui.providers.DriverProvider;

/**
 * The class describe WebElements Faded Short Sleeve T-shirts page.
 */
public class FadedShortSleeveTshirtsPage extends BasePage {

    @FindBy(css = "li .open-comment-form")
    private WebElement writeReviewButton;
    @FindBy(css = "[title='5']")
    private WebElement starsQuality;
    @FindBy(id = "comment_title")
    private WebElement title;
    @FindBy(id = "content")
    private WebElement comment;
    @FindBy(id = "submitNewMessage")
    private WebElement sendButton;
    @FindBy(css = ".fancybox-inner > p:nth-child(2)")
    private WebElement resultMessage;
    @FindBy(css = "button.button-medium > span:nth-child(1)")
    private WebElement okButton;

    public void submitWriteReviewButton() {
        writeReviewButton.click();
    }

    public void enterStarsQuality(int stars) {
        switch (stars) {
            case 1:
                DriverProvider.getDriver().findElement(By.cssSelector("[title='1']")).click();
                break;
            case 2:
                DriverProvider.getDriver().findElement(By.cssSelector("[title='2']")).click();
                break;
            case 3:
                DriverProvider.getDriver().findElement(By.cssSelector("[title='3']")).click();
                break;
            case 4:
                DriverProvider.getDriver().findElement(By.cssSelector("[title='4']")).click();
                break;
            case 5:
                DriverProvider.getDriver().findElement(By.cssSelector("[title='5']")).click();
                break;
            default:
                break;

        }
    }

    public void enterTitle(String titleMessage) {
        title.sendKeys(titleMessage);
    }

    public void enterComment(String commentMessage) {
        comment.sendKeys(commentMessage);
    }

    public FadedShortSleeveTshirtsPage submitSendButton() {
        sendButton.click();
        return new FadedShortSleeveTshirtsPage();
    }

    public String getResultMessage() {
        return resultMessage.getText();
    }

    public FadedShortSleeveTshirtsPage submitOkButton() {
        okButton.click();
        return new FadedShortSleeveTshirtsPage();
    }
}
