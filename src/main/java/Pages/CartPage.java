package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver ;

    private By LinkedInIcon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a");
    private By FacebookIcon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");
    private By XIcon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a");
    private By cart_item = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]");

    private By cart = By.xpath("//*[@data-test=\"inventory-item\"]");
    // Cart
    private By cartItems = By.className("cart_item");
    private By cartIcon = By.id("shopping_cart_container");
    private By continueShoppingBtn = By.xpath("//*[@id=\"continue-shopping\"]");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyOpened_URL_XIcon(){
        driver.findElement(XIcon).click();
    }
    public void verifyOpened_URL_FacebookIcon(){
        driver.findElement(FacebookIcon).click();
    }
    public void verifyOpened_URL_LinkedInIcon(){
        driver.findElement(LinkedInIcon).click();
    }

    public int getCartItemsCountempty() {
        return driver.findElements(cart_item).size();
    }
    public int getCartItemsCount() {
        return driver.findElements(cart).size();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }



    public void continueShopping() {
        driver.findElement(continueShoppingBtn).click();
    }


}
