package assessments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class day2demowebshoptescase3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		        // Navigate to Demo Web Shop
		        driver.get("https://demowebshop.tricentis.com/");
		        Thread.sleep(2000);

		        // 2. Identify 14.1-inch Laptop
		        WebElement laptop = driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']"));

		        // Identify Add to Cart button for the laptop
		        WebElement addToCartButton = laptop.findElement(By.xpath("./ancestor::div[contains(@class,'product-item')]//input[@value='Add to cart']"));

		        // Capture size of Add to Cart button
		        Dimension size = addToCartButton.getSize();

		        System.out.println("Add to Cart Button Size:");
		        System.out.println("Width  : " + size.getWidth());
		        System.out.println("Height : " + size.getHeight());

		        // Click Add to Cart
		        addToCartButton.click();

		        // 3. Click Shopping Cart
		        WebElement shoppingCart = driver.findElement(By.className("cart-label"));

		        shoppingCart.click();

		        // 4. Verify Remove checkbox and capture complete information using getRect()
		        WebElement removeCheckbox = driver.findElement(By.xpath("//input[@name='removefromcart']"));

		        
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

		        // 5. Verify alert before clicking Apply Coupon
		        WebElement applyCoupon = driver.findElement(By.xpath("//input[@value='Apply coupon']"));
				applyCoupon.click();
				 WebElement message = driver.findElement(By.className("message"));
				 if(message.isDisplayed()) {
					 System.out.println("Message displayed  Apply Coupon");
				 }else {
					 System.out.println("Message not displayed  Apply Coupon");
				 }
				 

		        // 6. Take screenshot of Laptop image
				 Thread.sleep(2000);
					TakesScreenshot tks=(TakesScreenshot) driver;
					File src=tks.getScreenshotAs(OutputType.FILE);
					File dest=new File("./LAs/Loptop.png");
					FileHandler.copy(src, dest);
	}
	}


