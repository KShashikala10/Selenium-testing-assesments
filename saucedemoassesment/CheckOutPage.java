
package SauceDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver d;

    WebDriverWait wait;


    public CheckoutPage(WebDriver d) {

        this.d = d;

        wait = new WebDriverWait(
                d,
                Duration.ofSeconds(10)
        );
    }


    // First Name field

    private By firstName =
            By.id("first-name");


    // Last Name field

    private By lastName =
            By.id("last-name");


    // Postal Code field

    private By postalCode =
            By.id("postal-code");


    // Continue button

    private By continueButton =
            By.id("continue");


    // Enter First Name

    public void enterFirstName(String name) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        firstName
                )
        );

        element.clear();

        element.sendKeys(name);
    }


    // Enter Last Name

    public void enterLastName(String name) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        lastName
                )
        );

        element.clear();

        element.sendKeys(name);
    }


    // Enter Postal Code

    public void enterPostalCode(String code) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        postalCode
                )
        );

        element.clear();

        element.sendKeys(code);
    }


    // Click Continue

    public void clickContinue() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(
                        continueButton
                )
        );

        button.click();

        // Wait until Checkout Overview page opens

        wait.until(
                ExpectedConditions.urlContains(
                        "checkout-step-two.html"
                )
        );
    }
}
