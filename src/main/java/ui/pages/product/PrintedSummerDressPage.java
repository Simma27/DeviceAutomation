package ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import ui.models.Colour;

import static ui.providers.DriverProvider.getDriver;

/**
 * The class describe WebElements Printed Summer Dress page.
 */
public class PrintedSummerDressPage extends BasePage {

    @FindBy(id = "bigpic")
    private WebElement bigPicture;

    public static PrintedSummerDressPage chooseDressColour(Colour colour) {
        getDriver().findElement(colour.getSelector()).click();
        return new PrintedSummerDressPage();
    }

    public String getAttributeBigPicture(String attribute) {
        return bigPicture.getAttribute(attribute);
    }

    public boolean isDisplayedBigPicture() {
        return bigPicture.isDisplayed();
    }



}
