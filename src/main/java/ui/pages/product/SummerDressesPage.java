package ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.main.BasePage;

/**
 * The class describe WebElements Summer Dress page.
 */
public class SummerDressesPage extends BasePage {

    @FindBy(css = "li.ajax_block_product:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)")
    private WebElement printedSummerDress;
    @FindBy(css = "li.ajax_block_product:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > a:nth-child(2) > span:nth-child(1)")
    private WebElement moreButton;

    public WebElement getPrintedSummerDress() {
        return printedSummerDress;
    }

    public WebElement getMoreButton() {
        return moreButton;
    }

}
