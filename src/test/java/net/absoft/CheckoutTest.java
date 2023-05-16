package net.absoft;

import net.absoft.data.Account;
import net.absoft.data.Customer;
import net.absoft.pages.CheckoutPage;
import net.absoft.pages.InventoryPage;
import net.absoft.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage ;
    private CheckoutPage checkPage;
    private final String ITEM = "Sauce Labs Backpack";
    Customer customer1 = Customer.FIRST_USER_INFO;
    Customer customer2 = Customer.SECOND_USER_INFO;
    public final String FirstNameError = "Error: First Name is required";
    public final String LastNameError = "Error: Last Name is required";
    public final String ZipCodeError = "Error: Postal Code is required";
    @BeforeMethod
    public void PayforOneItem(){
        loginPage = new LoginPage(driver);
        loginPage.login(Account.STANDARD_USER)
                .shouldSeePrimaryHeader();
        inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart(ITEM)
                .openCart()
                .checkItemPresence(ITEM)
                .checkoutButton.click();

    }
    @Test
    public void fillInfo() {
        checkPage = new CheckoutPage(driver);
        checkPage.firstNameInput.sendKeys(customer1.getFirstName());
        checkPage.lastNameInput.sendKeys(customer1.getLastName());
        checkPage.zipCodeInput.sendKeys(customer1.getZipCode());
        checkPage.continueButton.click();
        checkPage.finishButton.click();
        new CheckoutPage(driver).shouldSeePrimaryHeader();
    }

    @Test
    public void numberInfo() {
        checkPage = new CheckoutPage(driver);
        checkPage.firstNameInput.sendKeys(customer2.getFirstName());
        checkPage.lastNameInput.sendKeys(customer2.getLastName());
        checkPage.zipCodeInput.sendKeys(customer2.getZipCode());
        checkPage.continueButton.click();
        checkPage.finishButton.click();
        new CheckoutPage(driver).shouldSeePrimaryHeader();
    }

    @Test
    public void emptyInfoCheck() {
        checkPage = new CheckoutPage(driver);
        checkPage.continueButton.click();
        checkPage.checkOutErrorMessage(FirstNameError);
        checkPage.firstNameInput.sendKeys(customer1.getFirstName());
        checkPage.closeError.click();
        checkPage.continueButton.click();
        checkPage.checkOutErrorMessage(LastNameError);
        checkPage.lastNameInput.sendKeys(customer1.getLastName());
        checkPage.continueButton.click();
        checkPage.checkOutErrorMessage(ZipCodeError);
        checkPage.zipCodeInput.sendKeys(customer1.getZipCode());
        checkPage.continueButton.click();
        checkPage.finishButton.click();
        new CheckoutPage(driver).shouldSeePrimaryHeader();
    }
}
