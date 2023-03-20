package net.absoft.pages;

import io.qameta.allure.Step;
import net.absoft.data.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BaseStorePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "input[data-test='firstName']")
    public WebElement firstNameInput;
    @FindBy(css = "input[data-test='lastName']")
    public WebElement lastNameInput;
    @FindBy(css = "input[data-test='postalCode']")
    public WebElement zipCodeInput;
    @FindBy(css = "button#cancel")
    public WebElement cancelButton;
    @FindBy(css = "button#continue")
    public WebElement continueButton;
    @FindBy(css = "button#finish")
    public WebElement finishButton;

    @Step("Fill customer info with Name: {customer.firstName} LastName: {customer.lastName} and code: {customer.zipCode}")
    public CheckoutPage fillInfo(Customer customer){
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        zipCodeInput.sendKeys(customer.getZipCode());
        continueButton.click();
        finishButton.click();
        return new CheckoutPage(driver);
    }
}
