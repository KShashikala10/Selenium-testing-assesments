
package SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver d;

    WebDriverWait wait;


    public CartPage(WebDriver d) {

        this.d = d;

        PageFactory.initElements(d, this);

        wait = new WebDriverWait(
                d,
                
                Duration.ofSeconds(10)
        );
    }


    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement backpack;


    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    public boolean isBackpackDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        org.openqa.selenium.By.xpath(
                                "//div[text()='Sauce Labs Backpack']")
                )
        ).isDisplayed();
    }


    public void clickCheckout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        checkoutButton
                )
        );

        checkoutButton.click();
    }
}
