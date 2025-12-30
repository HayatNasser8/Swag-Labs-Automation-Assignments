package Tests;

import Base.BaseTest;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DataDriven;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

public class InventoryTest extends BaseTest {

    //task1
    @Test
    public void verifyInventoryPageElements() {
        Map<String, Object> data = DataDriven.readJson("src/main/resources/testData.json");
        Map<String, String> validUser = (Map<String, String>) data.get("validData");

        InventoryPage inventoryPage = loginPage.login(validUser.get("username"), validUser.get("password"));

        Assert.assertTrue(inventoryPage.getPageTitle());
        Assert.assertTrue(inventoryPage.isDisplayedCartIcon());
        Assert.assertTrue(inventoryPage.isProductsCountSix());
    }
    @Test
    public void addThreeSpecificProducts() {
        Map<String, Object> data = DataDriven.readJson("src/main/resources/testData.json");
        Map<String, String> validUser = (Map<String, String>) data.get("validData");

        InventoryPage inventoryPage =
                loginPage.login(validUser.get("username"), validUser.get("password"));

//        inventoryPage.Backpack();

        inventoryPage.addThreeProducts();
//
        cartPage.openCart();
//
        Assert.assertEquals(cartPage.getCartItemsCount(), 3);
    }

    @Test(dependsOnMethods = "addThreeSpecificProducts")
    public void removeOneProduct() {

        cartPage.continueShopping();

        inventoryPage.removeBoltTShirt();

//
        Assert.assertTrue(inventoryPage.isProductAdded("Sauce Labs Backpack"), "Backpack should still be added");

//
    }




}
