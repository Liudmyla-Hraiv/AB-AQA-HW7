package net.absoft.pages;

import net.absoft.components.PrimaryHeader;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;

public abstract class BaseStorePage extends BaseComponent {
    private final PrimaryHeader header = new PrimaryHeader(driver);
    public BaseStorePage(WebDriver driver) {
        super(driver);
    }


    public BaseStorePage shouldSeePrimaryHeader() {
        header.shouldSeePrimaryHeader();
        return this;
    }

    public CartPage openCart() {
        return header.openCart();
    }

}
