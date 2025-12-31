package Tests;

import Base.BaseTest;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DataDriven;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin()  {
        Map<String, Object> data = DataDriven.readJson("src/main/resources/testData.json");
        Map<String, String> validUser = (Map<String, String>) data.get("validData");

        InventoryPage inventoryPage = loginPage.login(validUser.get("username"), validUser.get("password"));

        Assert.assertTrue(inventoryPage.getPageTitle());
    }

    @Test
    public void verifyInvalidLogin()  {
        Map<String, Object> data = DataDriven.readJson("src/main/resources/testData.json");
        Map<String, String> InvalidUser = (Map<String, String>) data.get("InvalidData");

        loginPage.login(InvalidUser.get("username"), InvalidUser.get("password"));

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }
   @Test
    public void verifyLoginWithoutPassword()  {
        Map<String, Object> data = DataDriven.readJson("src/main/resources/testData.json");
        Map<String, String> WithoutPasswordData = (Map<String, String>) data.get("WithoutPasswordData");

       loginPage.login(WithoutPasswordData.get("username"), WithoutPasswordData.get("password"));

       Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"));
    }

}
