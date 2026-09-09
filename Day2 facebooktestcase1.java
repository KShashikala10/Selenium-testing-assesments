package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day2facebooktescase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.facebook.com/");
	    driver.findElement(By.xpath("//span[text()='Create new account']")).click();
	    WebElement firstname = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
        WebElement surname = driver.findElement(By.id("_R_1kl2p4jikacppb6amH1_"));

        int firstnameY = firstname.getLocation().getY();
        int surnameY = surname.getLocation().getY();

        if (firstnameY == surnameY) {
            System.out.println("PASS: First name and Surname fields are aligned in the same line.");
        } else {
            System.out.println("FAIL: First name and Surname fields are NOT aligned in the same line.");
        }

        driver.quit();
	    

	}

}
