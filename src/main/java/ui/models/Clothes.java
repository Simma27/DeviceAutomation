package ui.models;

import org.openqa.selenium.By;

public enum Clothes {

    CASUAL_DRESSES(By.cssSelector(".sf-menu > li:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")),
    SUMMER_DRESSES(By.cssSelector(".sf-menu > li:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)")),
    EVENING_DRESSES(By.cssSelector(".sf-menu > li:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")),
    BLOUSES(By.cssSelector("[title='Blouses']")),
    T_SHIRTS(By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a"));

    private By selector;

    Clothes(By selector) {
        this.selector = selector;
    }

    public By getSelector() {
        return selector;
    }

}
