package net.absoft.pages;

import io.qameta.allure.Step;
import net.absoft.data.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckoutPage extends BaseStorePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[data-test='firstName']")
    public WebElement firstNameInput;
    @FindBy(css = "input[data-test='lastName']")
    public WebElement lastNameInput;
    @FindBy(css = "input[data-test='postalCode']")
    public WebElement zipCodeInput;
    @FindBy(css = "button.error-button")
    public WebElement closeError;
    @FindBy(css = "button#cancel")
    public WebElement cancelButton;
    @FindBy(css = "input[data-test='continue']")
    public WebElement continueButton;
    @FindBy(css = "button#finish")
    public WebElement finishButton;
    private final String itemXPath = "//div[@class='cart_item'][.//div[@class='inventory_item_name' and text()='%s']]";
    private final String xPathMessage = "//div[@class='error-message-container error'][.//h3[@data-test='error' and text()='%s']]";

    // @Step("Fill customer info with Name: {customer.firstName} LastName: {customer.lastName} and code: {customer.zipCode}")
    public CheckoutPage fillInfo(Customer customer) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        zipCodeInput.sendKeys(customer.getZipCode());
        continueButton.click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkOutItemPresence(String itemName) {
        String itemXPathFormatted = String.format(itemXPath, itemName);
        assertTrue(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
                        && driver.findElement(By.xpath(itemXPathFormatted)).isDisplayed(),
                "Item " + itemName + " was not added to Payment Page");
        return this;
    }

    public CheckoutPage checkOutItemAbsent(String itemName) {
        String itemXPathFormatted = String.format(itemXPath, itemName);
        assertFalse(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
                        && driver.findElement(By.xpath(itemXPathFormatted)).isDisplayed(),
                itemName + " was not removed from  Payment Page");
        return this;
    }

    public CheckoutPage checkOutErrorMessage(String message) {
        String messageXPathFormatted = String.format(xPathMessage, message);
        assertTrue(!driver.findElements(By.xpath(messageXPathFormatted)).isEmpty()
                        && driver.findElement(By.xpath(messageXPathFormatted)).isDisplayed(),
                message + " error is absent");
        return this;
    }
}