package net.absoft;


import net.absoft.data.Account;
import net.absoft.pages.InventoryPage;
import net.absoft.pages.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{
    Account account = Account.STANDARD_USER;
    @Test (description = "Test successful Login")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameInput.sendKeys(account.getLogin());
        loginPage.passwordInput.sendKeys(account.getPassword());
        loginPage.loginButton.click();
        new InventoryPage(driver).shouldSeePrimaryHeader();

    }
    Account lockAccount = Account.LOCKED_USER;
    @Test (description = "Test lock out user Login")
    public void testLockOutUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameInput.sendKeys(lockAccount.getLogin());
        loginPage.passwordInput.sendKeys(lockAccount.getPassword());
        loginPage.loginButton.click();
        new InventoryPage(driver).shouldSeePrimaryHeader();
    }
}
