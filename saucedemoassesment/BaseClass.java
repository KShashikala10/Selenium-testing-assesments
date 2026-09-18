package SauceDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    WebDriver d;

    @BeforeMethod
    public void openBrowser() {

        System.out.println("Open the browser");

        ChromeOptions options =
                new ChromeOptions();

        // Disable Chrome password manager

        options.addArguments(
                "--disable-features=PasswordLeakDetection"
        );

        options.setExperimentalOption(
                "prefs",
                java.util.Map.of(
                        "credentials_enable_service", false,
                        "profile.password_manager_leak_detection", false
                )
        );

        d = new ChromeDriver(options);

        d.manage().window().maximize();

        d.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );

        d.get("https://www.saucedemo.com/");
    }


    @AfterMethod
    public void closeBrowser() {

        System.out.println("Close the browser");

        if (d != null) {
            d.quit();
        }
    }
}
