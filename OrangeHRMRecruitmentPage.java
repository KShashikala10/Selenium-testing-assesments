package Pomutilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMRecruitmentPage {

    WebDriver driver;

    public OrangeHRMRecruitmentPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    // ============================================================
    // ADD BUTTON
    // ============================================================

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;


    // ============================================================
    // FIRST NAME
    // ============================================================

    @FindBy(name = "firstName")
    private WebElement firstName;


    // ============================================================
    // MIDDLE NAME
    // ============================================================

    @FindBy(name = "middleName")
    private WebElement middleName;


    // ============================================================
    // LAST NAME
    // ============================================================

    @FindBy(name = "lastName")
    private WebElement lastName;


    // ============================================================
    // EMAIL
    // ============================================================

    @FindBy(xpath = "//label[normalize-space()='Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement email;


    // ============================================================
    // CONTACT NUMBER
    // ============================================================

    @FindBy(xpath = "//label[normalize-space()='Contact Number']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement contactNumber;


    // ============================================================
    // RESUME
    // ============================================================

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resume;


    // ============================================================
    // SAVE BUTTON
    // ============================================================

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;


    // ============================================================
    // CANDIDATES TAB
    // ============================================================

    @FindBy(xpath = "//a[normalize-space()='Candidates']")
    private WebElement candidates;


    // ============================================================
    // CLICK ADD
    // ============================================================

    public void clickAdd() {

        addButton.click();
    }


    // ============================================================
    // FIRST NAME
    // ============================================================

    public void enterFirstName(String value) {

        firstName.sendKeys(value);
    }


    // ============================================================
    // MIDDLE NAME
    // ============================================================

    public void enterMiddleName(String value) {

        middleName.sendKeys(value);
    }


    // ============================================================
    // LAST NAME
    // ============================================================

    public void enterLastName(String value) {

        lastName.sendKeys(value);
    }


    // ============================================================
    // VACANCY
    // ============================================================

    public void selectVacancy(String value) {

        WebElement vacancyDropdown = driver.findElement(

                By.xpath(
                        "//label[normalize-space()='Vacancy']" +
                        "/ancestor::div[contains(@class,'oxd-input-group')]" +
                        "//div[contains(@class,'oxd-select-text')]"
                )
        );

        vacancyDropdown.click();


        List<WebElement> options = driver.findElements(

                By.xpath("//div[contains(@class,'oxd-select-option')]")
        );


        for (WebElement option : options) {

            if (option.getText().trim().equals(value)) {

                option.click();

                return;
            }
        }
    }


    // ============================================================
    // EMAIL
    // ============================================================

    public void enterEmail(String value) {

        email.sendKeys(value);
    }


    // ============================================================
    // CONTACT NUMBER
    // ============================================================

    public void enterContactNumber(String value) {

        contactNumber.sendKeys(value);
    }


    // ============================================================
    // RESUME
    // ============================================================

    public void getResume(String path) {

        resume.sendKeys(path);
    }


    // ============================================================
    // SAVE
    // ============================================================

    public void getSaveButton() {

        saveButton.click();
    }


    // ============================================================
    // CANDIDATES
    // ============================================================

    public void clickCandidates() {

        candidates.click();
    }

}
