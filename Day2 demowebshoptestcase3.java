package assessments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class day2demowebshoptescase3 {

    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(2000);

        // 1. Identify 14.1-inch Laptop
        WebElement laptop = driver.findElement(
                By.xpath("//a[text()='14.1-inch Laptop']")
        );

        // 2. Identify Add to Cart button
        WebElement addToCartButton = laptop.findElement(
                By.xpath("./ancestor::div[contains(@class,'product-item')]//input[@value='Add to cart']")
        );

        // Capture button size
        Dimension size = addToCartButton.getSize();

        System.out.println("Add to Cart Button Size:");
        System.out.println("Width  : " + size.getWidth());
        System.out.println("Height : " + size.getHeight());

        // Click Add to Cart
        addToCartButton.click();

        // 3. Click Shopping Cart
        WebElement shoppingCart = driver.findElement(By.className("cart-label"));
        shoppingCart.click();

        // 4. Verify Remove checkbox
        WebElement removeCheckbox = driver.findElement(
                By.xpath("//input[@name='removefromcart']")
        );

        if (removeCheckbox.isSelected()) {
            System.out.println("Remove checkbox is selected.");
        } else {
            System.out.println("Remove checkbox is NOT selected.");
        }

        // Capture complete information using getRect()
        Rectangle rect = removeCheckbox.getRect();

        System.out.println("\nCheckbox Complete Information using getRect():");
        System.out.println("X      : " + rect.getX());
        System.out.println("Y      : " + rect.getY());
        System.out.println("Width  : " + rect.getWidth());
        System.out.println("Height : " + rect.getHeight());

        // 5. Identify Apply Coupon button
        WebElement applyCoupon = driver.findElement(
                By.xpath("//input[@value='Apply coupon']")
        );
        applyCoupon.click();
        

        // BEFORE clicking Apply Coupon
        System.out.println("\nBefore clicking Apply Coupon:");

        WebElement messageBefore = driver.findElement(
                By.className("message")
        );
      

        if (messageBefore.isDisplayed()) {
            System.out.println("Message/Alert is displayed BEFORE clicking Apply Coupon.");
            System.out.println("Message: " + messageBefore.getText());
        } else {
            System.out.println("Message/Alert is NOT displayed BEFORE clicking Apply Coupon.");
        }

        Thread.sleep(1000);

        // AFTER clicking Apply Coupon
        WebElement applyCoupon1 = driver.findElement(
                By.xpath("//input[@value='Apply coupon']")
        );
        applyCoupon1.click();
        System.out.println("\nAfter clicking Apply Coupon:");

        WebElement messageAfter = driver.findElement(
                By.className("message")
        );
      

        if (messageAfter.isDisplayed()) {
            System.out.println("Message/Alert is displayed AFTER clicking Apply Coupon.");
            System.out.println("Message: " + messageAfter.getText());
        } else {
            System.out.println("Message/Alert is NOT displayed AFTER clicking Apply Coupon.");
        }
        

        // 6. Take screenshot
        Thread.sleep(2000);

        TakesScreenshot tks = (TakesScreenshot) driver;

        File src = tks.getScreenshotAs(OutputType.FILE);

        File dest = new File("./LAs/Loptop.png");

        FileHandler.copy(src, dest);

        System.out.println("\nScreenshot captured successfully.");

        driver.quit();
    }
}
