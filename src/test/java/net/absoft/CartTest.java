package net.absoft;


import net.absoft.data.Account;
import net.absoft.data.Customer;
import net.absoft.pages.CartPage;
import net.absoft.pages.CheckoutPage;
import net.absoft.pages.InventoryPage;
import net.absoft.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CartTest extends BaseTest{
    private final String ITEM = "Sauce Labs Backpack";
    private final String ITEM2 = "Sauce Labs Fleece Jacket";
    private final String ITEM3 = "Sauce Labs Bolt T-Shirt";
    private InventoryPage inventoryPage;
    private CheckoutPage checkout;
    private CartPage cartPage ;
    @BeforeMethod
    public void setUp(){
         new LoginPage(driver)
                .login(Account.STANDARD_USER)
                .shouldSeePrimaryHeader();
         inventoryPage = new InventoryPage(driver);
         checkout = new CheckoutPage(driver);
         cartPage = new CartPage(driver);
    }
    @Test
    public void testAddingItemToCart() {
        inventoryPage
                .addItemToCart(ITEM)
                .openCart()
                .checkItemPresence(ITEM)
                .continueShoppingButton.click();
    }
    @Test
    public void testRemovedItemOnInventoryPage() {
        inventoryPage
                .addItemToCart(ITEM2)
                .addItemToCart(ITEM3)
                .removeItemOnInventoryPage(ITEM2)
                .openCart()
                .checkItemPresence(ITEM3)
                .checkItemAbsent(ITEM2)
                .checkoutButton.click();
          checkout.fillInfo(Customer.FIRST_USER_INFO)
                .checkOutItemPresence(ITEM3)
                .checkOutItemAbsent(ITEM2);


    }
    @Test
    public void testRemovedItemOnCartPage() {
        inventoryPage
                .addItemToCart(ITEM)
                .addItemToCart(ITEM2)
                .openCart()
                .removeItemFromCart(ITEM2)
                .checkItemPresence(ITEM)
                .checkItemAbsent(ITEM2)
                .checkoutButton.click();
      checkout.fillInfo(Customer.FIRST_USER_INFO)
             .checkOutItemPresence(ITEM)
              .checkOutItemAbsent(ITEM2);

    }
}
