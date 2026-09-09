package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day2facebooktestcase2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		//getLocation
		WebElement loc = driver.findElement(By.xpath("//span[text()='Create new account']"));
		System.out.println(loc.getLocation());
		System.out.println(loc.getLocation().getX());
		System.out.println(loc.getLocation().getY());
		//getDomAttribute
		//getDomProperty
		WebElement DOM = driver.findElement(By.id("R_1h6kqsqppb6amH1"));
		System.out.println(DOM.getDomAttribute("value"));
		System.out.println(DOM.getDomProperty("value"));
		DOM.sendKeys("test@gmail.com");
		System.out.println(DOM.getDomAttribute("value"));
		System.out.println(DOM.getDomProperty("value"));
		
		
		loc.click();
		//size
		WebElement size = driver.findElement(By.xpath("//span[text()='Submit']"));
		System.out.println(size.getSize());
		System.out.println(size.getSize().getHeight());
		System.out.println(size.getSize().getWidth());
		
		
		//cssvalue
		System.out.println(size.getCssValue("background-color"));
		System.out.println(size.getCssValue("font-size"));
		System.out.println(size.getCssValue("font-weight"));
	}

}
		
		
	  
	

