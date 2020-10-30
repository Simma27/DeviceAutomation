package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrintedSummerDressPage extends BasePage {

    @FindBy(id = "thumb_12")
    private WebElement blackDress;
    @FindBy(id = "thumb_13")
    private WebElement orangeDress;
    @FindBy(id = "thumb_14")
    private WebElement blueDress;
    @FindBy(id = "thumb_15")
    private WebElement yellowDress;
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

    public WebElement getBlackDress() {
        return blackDress;
    }

    public WebElement getOrangeDress() {
        return orangeDress;
    }

    public WebElement getBlueDress() {
        return blueDress;
    }

    public WebElement getYellowDress() {
        return yellowDress;
    }

    public PrintedSummerDressPage chooseBlackColour() {
        blackColour.click();
        return new PrintedSummerDressPage();
    }

    public PrintedSummerDressPage chooseOrangeColour() {
        orangeColour.click();
        return new PrintedSummerDressPage();
    }

    public PrintedSummerDressPage chooseBlueColour() {
        blueColour.click();
        return new PrintedSummerDressPage();
    }

    public PrintedSummerDressPage chooseYellowColour() {
        yellowColour.click();
        return new PrintedSummerDressPage();
    }

    public WebElement getBigPicture() {
        return bigPicture;
    }
}
