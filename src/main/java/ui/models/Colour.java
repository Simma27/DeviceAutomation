package ui.models;

import org.openqa.selenium.By;

public enum Colour {

    BLACK(By.id("color_11")),
    ORANGE(By.id("color_13")),
    BLUE(By.id("color_14")),
    YELLOW(By.id("color_16"));

    public By getSelector() {
        return selector;
    }

    private By selector;

    Colour(By selector) {
        this.selector = selector;
    }
}
