package net.absoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CartPage extends BaseStorePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button#continue-shopping")
    public WebElement continueShoppingButton;
    @FindBy(css = "button#checkout")
    public WebElement checkoutButton;
    private final String itemXPath ="//div[@class='cart_item'][.//div[@class='inventory_item_name' and text()='%s']]";
  public CartPage checkItemPresence (String itemName){
      String itemXPathFormatted = String.format(itemXPath, itemName);
      assertTrue(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
                      && driver.findElement(By.xpath(itemXPathFormatted)).isDisplayed(),
              "Item " + itemName + " was not added to Cart Page");
      return this;
  }
  public CartPage checkItemAbsent(String itemName){
      String itemXPathFormatted = String.format(itemXPath, itemName);
      assertFalse(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
                      && driver.findElement(By.xpath(itemXPathFormatted)).isDisplayed(),
              "Item " + itemName + " was not removed from Cart Page");
      return this;
  }
    public CartPage removeItemFromCart(String itemName){
        String itemXPathFormatted = String.format(itemXPath, itemName);
        WebElement item3 = driver.findElement(By.xpath(itemXPathFormatted));
        WebElement removeFromCartButton = item3.findElement(By.xpath(".//button[contains(@data-test, 'remove-sauce-labs')]"));
        removeFromCartButton.click();
        return this;
    }
}
