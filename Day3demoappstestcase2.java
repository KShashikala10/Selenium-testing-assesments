package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day3demoapptestcase2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[normalize-space(text())='Write a script to select date from future month but current year?']")).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Select A Date']")).click();
		driver.findElement(By.xpath("//div[text()='12']")).click();
		String date = driver.findElement(By.xpath("//input[@placeholder='Select A Date']"))
                .getAttribute("value");

		System.out.println("Selected Date: " + date);

        if (date.contains("12")) {
            System.out.println("PASS: Date 12 is selected");
        } else {
            System.out.println("FAIL: Date 12 is not selected");
        }

        driver.quit();
	}

}
