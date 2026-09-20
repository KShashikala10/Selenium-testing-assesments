package pomImplementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // =========================
    // LOGIN LOCATORS
    // =========================

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;


    // =========================
    // LOGOUT LOCATORS
    // ADD THESE HERE
    // =========================

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;


    // =========================
    // LOGIN METHOD
    // =========================

    public void login(String user, String pass) {

        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }


    // =========================
    // LOGOUT METHOD
    // ADD THIS AFTER login()
    // =========================

    public void logout() {

        userDropdown.click();
        logout.click();
    }
}
