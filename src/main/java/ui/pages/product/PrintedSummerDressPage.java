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

    @FindBy(id = "color_11")
    private WebElement blackColour;

    @FindBy(id = "color_13")
    private WebElement orangeColour;

    @FindBy(id = "color_14")
    private WebElement blueColour;

    @FindBy(id = "color_16")
    private WebElement yellowColour;

    @FindBy(id = "bigpic")
    private WebElement bigPicture;

    public static PrintedSummerDressPage chooseDressColour(Colour colour) {
        getDriver().findElement(colour.getSelector()).click();
        return new PrintedSummerDressPage();
    }

    public WebElement getBigPicture() {
        return bigPicture;
    }

}
