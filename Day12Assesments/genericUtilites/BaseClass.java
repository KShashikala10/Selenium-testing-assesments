package genericUtilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public WebDriver driver;
    public Properties prop;

    @BeforeClass
    public void setup() throws Exception {

        // Read properties file
        FileInputStream fis = new FileInputStream(
                "./src/main/resources/DDT/commondata.properties1");

        prop = new Properties();
        prop.load(fis);

        // Launch browser
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open OrangeHRM
        driver.get(prop.getProperty("url"));
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
