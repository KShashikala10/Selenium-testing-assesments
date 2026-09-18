package SauceDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver d;

    By username = By.id("user-name");

    By password = By.id("password");

    By loginButton = By.id("login-button");

    public LoginPage(WebDriver d) {
        this.d = d;
    }

    public void enterUsername(String usernameValue) {

        d.findElement(username).sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {

        d.findElement(password).sendKeys(passwordValue);
    }

    public void clickLogin() {

        d.findElement(loginButton).click();
    }

    public void login(String usernameValue,
                      String passwordValue) {

        enterUsername(usernameValue);

        enterPassword(passwordValue);

        clickLogin();
    }
}
