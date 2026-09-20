package pomImplementation;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfoPage {

    WebDriver driver;

    public MyInfoPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfo;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//label[contains(text(),'Employee Id')]/../following-sibling::div//input")
    private WebElement employeeId;

    //@FindBy(xpath = "//button[@type='submit']")
    //private WebElement saveButton;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;


    public void clickMyInfo() throws InterruptedException {

        myInfo.click();

        Thread.sleep(2000);
    }
    

    public void editEmployeeDetails(
            String first,
            String last,
            String empId) throws InterruptedException {

        firstName.click();
        firstName.sendKeys(
                org.openqa.selenium.Keys.CONTROL,
                "a");
        firstName.sendKeys(first);

        lastName.click();
        lastName.sendKeys(
                org.openqa.selenium.Keys.CONTROL,
                "a");
        lastName.sendKeys(last);

        employeeId.click();
        employeeId.sendKeys(
                org.openqa.selenium.Keys.CONTROL,
                "a");
        employeeId.sendKeys(empId);

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(saveButton));

        saveButton.click();

        Thread.sleep(2000);
    }

    public String getFirstName() {

        return firstName.getAttribute("value");
    }

    public String getLastName() {

        return lastName.getAttribute("value");
    }

    public String getEmployeeId() {

        return employeeId.getAttribute("value");
    }
}
