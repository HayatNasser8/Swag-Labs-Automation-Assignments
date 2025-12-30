package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage{
    private WebDriver driver ;
    private By userNameFiled = By.xpath("//*[@id=\"user-name\"]");
    private By passwordFiled = By.xpath("//*[@id=\"password\"]");
    private By loginButton = By.cssSelector("#login-button");
    private By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String userName){
        driver.findElement(userNameFiled).sendKeys(userName);
    }

    public void enterPassword(String password){
        driver.findElement(passwordFiled).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public InventoryPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new InventoryPage(driver);
    }
    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("inventory");
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }


}
