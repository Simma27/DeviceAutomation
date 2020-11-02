package ui.services.product;

import io.qameta.allure.Step;
import ui.pages.product.PrintedSummerDressPage;

/**
 * The class consist of methods to work with Printed Summer Dress page.
 */
public class PrintedSummerDressPageService {

    /**
     * Method allow to choose black dress.
     * @return
     */
    @Step
    public static PrintedSummerDressPage chooseBlackColour() {
        PrintedSummerDressPage page = new PrintedSummerDressPage();
        return page.chooseBlackColour();
    }
    /**
     * Method allow to choose orange dress.
     * @return
     */
    @Step
    public static PrintedSummerDressPage chooseOrangeColour() {
        PrintedSummerDressPage page = new PrintedSummerDressPage();
        return page.chooseOrangeColour();
    }
    /**
     * Method allow to choose blue dress.
     * @return
     */
    @Step
    public static PrintedSummerDressPage chooseBlueColour() {
        PrintedSummerDressPage page = new PrintedSummerDressPage();
        return page.chooseBlueColour();
    }
    /**
     * Method allow to choose yellow dress.
     * @return
     */
    @Step
    public static PrintedSummerDressPage chooseYellowColour() {
        PrintedSummerDressPage page = new PrintedSummerDressPage();
        return page.chooseYellowColour();
    }
}
