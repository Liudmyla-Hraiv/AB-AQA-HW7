package net.absoft;

import net.absoft.data.Customer;
import net.absoft.pages.CheckoutPage;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    private CheckoutPage check = new CheckoutPage(driver);
    Customer customer1 = Customer.FIRST_USER_INFO;
    Customer customer2 = Customer.FIRST_USER_INFO;

    @Test
    public void fillInfo() {
        check.firstNameInput.sendKeys(customer1.getFirstName());
        check.lastNameInput.sendKeys(customer1.getFirstName());
        check.zipCodeInput.sendKeys(customer1.getZipCode());
        check.continueButton.click();
        check.finishButton.click();
        new CheckoutPage(driver).shouldSeePrimaryHeader();
    }
}
