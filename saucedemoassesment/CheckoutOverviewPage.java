
package SauceDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage {

    WebDriver d;

    WebDriverWait wait;


    public CheckoutOverviewPage(WebDriver d) {

        this.d = d;

        wait = new WebDriverWait(
                d,
                Duration.ofSeconds(10)
        );
    }


    // Overview page title

    private By overviewTitle =
            By.cssSelector(".title");


    // Finish button

    private By finishButton =
            By.id("finish");


    // Order confirmation message

    private By confirmationMessage =
            By.cssSelector(".complete-header");


    // Get Overview title

    public String getOverviewTitle() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        overviewTitle
                )
        ).getText();
    }


    // Click Finish

    public void clickFinish() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        finishButton
                )
        ).click();
    }


    // Get confirmation message

    public String getConfirmationMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        confirmationMessage
                )
        ).getText();
    }
}
