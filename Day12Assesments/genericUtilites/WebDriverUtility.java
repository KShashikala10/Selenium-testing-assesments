package genericUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

    public void waitForElement(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }
}
