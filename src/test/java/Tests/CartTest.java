package Tests;

import Base.BaseTest;
import Pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DataDriven;

import java.util.Map;
import java.util.Set;

public class CartTest extends BaseTest {

    // helper method for tabs
    private void switchToNewTab() {
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            driver.switchTo().window(tab);
        }
    }

    @Test
    public void verifySocialLinkLinkedin() {
        Map<String, Object> data = DataDriven.readJson("src/main/resources/testData.json");
        Map<String, String> validUser = (Map<String, String>) data.get("validData");

        loginPage.login(validUser.get("username"), validUser.get("password"));
        cartPage.verifyOpened_URL_LinkedInIcon();
        switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"));
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }

    @Test
    public void verifySocialLinkFacebook() {
        Map<String, Object> data = DataDriven.readJson("src/main/resources/testData.json");
        Map<String, String> validUser = (Map<String, String>) data.get("validData");

        loginPage.login(validUser.get("username"), validUser.get("password"));

        cartPage.verifyOpened_URL_FacebookIcon();
        switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }

    @Test
    public void verifySocialLinkX() {
        Map<String, Object> data = DataDriven.readJson("src/main/resources/testData.json");
        Map<String, String> validUser = (Map<String, String>) data.get("validData");

        loginPage.login(validUser.get("username"), validUser.get("password"));
        cartPage.verifyOpened_URL_XIcon();
        switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("x.com"));
    }



    @Test
    public void verifyCartIsEmpty() {
        Map<String, Object> data = DataDriven.readJson("src/main/resources/testData.json");
        Map<String, String> validUser = (Map<String, String>) data.get("validData");

        loginPage.login(validUser.get("username"), validUser.get("password"));

        cartPage.getCartItemsCount();

        Assert.assertEquals(cartPage.getCartItemsCountempty(), 0, "Cart is not empty");
    }

    @Test
    public void addThreeSpecificProducts() {
        Map<String, Object> data = DataDriven.readJson("src/main/resources/testData.json");
        Map<String, String> validUser = (Map<String, String>) data.get("validData");

        InventoryPage inventoryPage =
                loginPage.login(validUser.get("username"), validUser.get("password"));


        inventoryPage.addThreeProducts();
//
        cartPage.openCart();
//
        Assert.assertEquals(cartPage.getCartItemsCount(), 3);
    }





}
