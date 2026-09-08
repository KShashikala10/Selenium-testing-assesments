package assessments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class day1saucedemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		Thread.sleep(3000);
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    Thread.sleep(3000);
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    Thread.sleep(3000);
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollTo(0,500)");
	    Thread.sleep(3000);
	    
	    TakesScreenshot tks = (TakesScreenshot) driver;
		   File src= tks.getScreenshotAs(OutputType.FILE);
		   File dest = new File("./Sa/products-page.png");
		   FileHandler.copy(src, dest);
		   
	    
	    
		
		

	}

}
