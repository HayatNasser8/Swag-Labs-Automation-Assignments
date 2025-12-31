package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {
    private WebDriver driver ;
    // task1
    private By pageTitle  = By.xpath("//*[@class=\"app_logo\"]");
    private By cartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By products = By.xpath("//*[@data-test=\"inventory-list\"]/div");

//    // task2

// Add products
    private By backpackAdd = By.id("add-to-cart-sauce-labs-backpack");
    private By boltTshirtAdd = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By onesieAdd = By.id("add-to-cart-sauce-labs-onesie");

    // Remove buttons
    private By backpackRemove = By.id("remove-sauce-labs-backpack");
    private By boltTshirtRemove = By.id("remove-sauce-labs-bolt-t-shirt");
    private By onesieRemove = By.id("remove-sauce-labs-onesie");

    private By inventoryItems = By.className("inventory_item");
    private By Backpack = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By BoltT_Shirt = By.xpath("//*[@id=\"item_1_title_link\"]/div");
    private By Onesie = By.xpath("//*[@id=\"item_2_title_link\"]/div");
    private By addBackpack = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    private By addBoltT_Shirt = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
    private By addOnesie = By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]");

    // Remove buttons
    private By removeBackpack = By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    //task1
    public boolean getPageTitle(){
        return driver.getTitle().equals("Swag Labs");
    }

    public boolean isDisplayedCartIcon(){
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getNumberOfItems(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(products, 6));
        return driver.findElements(products).size();
    }
    public boolean isProductsCountSix() {
        return getNumberOfItems() == 6;
    }
    public void clickAddBackpack(){
        driver.findElement(addBackpack).click();
    }
    public void clickAddBoltT_Shirt(){
        driver.findElement(addBoltT_Shirt).click();
    }
    public void clickAddOnesie(){
        driver.findElement(addOnesie).click();
    }
    public void Backpack(){
        String title = driver.findElement(Backpack).getText();
        if (!title.isEmpty()){
            clickAddBackpack();
        }
    }
    public void BoltT_Shirt(){
        String title = driver.findElement(BoltT_Shirt).getText();
        if (!title.isEmpty()){
            clickAddBoltT_Shirt();
        }
    }
    public void Onesie(){
        String title = driver.findElement(Backpack).getText();
        if (!title.isEmpty()){
            clickAddOnesie();
        }
    }
    public void addThreeProducts() {
        Backpack();
        BoltT_Shirt();
        Onesie();
    }
    public boolean checkRemove(){
        return driver.findElement(Backpack).isEnabled();
    }


    public void removeBoltTShirt(){
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );
        driver.findElement(removeBackpack).click();
    }
    public boolean isProductRemoved(String productName) {
        return driver.findElements(
                By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button[contains(text(),'Remove')]")
        ).isEmpty();
    }

    public boolean isProductAdded(String productName) {
        return driver.findElements(addBackpack).size() > 0;
    }




    // task2

public void addProductByName(String productName) {

    List<WebElement> items = driver.findElements(inventoryItems);

    for (WebElement item : items) {

        String name = item
                .findElement(By.className("inventory_item_name"))
                .getText();

        if (name.equals(productName)) {

            item.findElement(
                    By.cssSelector("button[data-test^='add-to-cart']")
            ).click();

            break; // مهم جدًا
        }
    }
}





}
