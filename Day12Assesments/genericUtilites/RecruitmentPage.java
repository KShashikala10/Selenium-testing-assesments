package pomImplementation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage {

    WebDriver driver;

    public RecruitmentPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitment;

    @FindBy(xpath = "//a[text()='Vacancies']")
    private WebElement vacancies;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//label[text()='Vacancy Name']/../following-sibling::div//input")
    private WebElement vacancyName;

    @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'select-text')]")
    private WebElement jobTitle;

    @FindBy(xpath = "//textarea")
    private WebElement description;

   // @FindBy(xpath = "//label[contains(text(),'Hiring Manager')]/../following-sibling::div//input")
    //private WebElement hiringManager;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement hiringManager;

    //@FindBy(xpath = "//label[contains(normalize-space(),'Number of Positions')]/ancestor::div[contains(@class,'oxd-input-group')]//input")
    //private WebElement numberOfPositions;
    
    @FindBy(xpath = "//label[contains(normalize-space(),'Number of Positions')]/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement numberOfPositions;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    public void clickRecruitment() {

        recruitment.click();
    }

    public void clickVacancies() {

        vacancies.click();
    }

    public void clickAdd() {

        addButton.click();
    }

    public void enterVacancyName(String name) {

        vacancyName.sendKeys(name);
    }

    public void selectJobTitle(String title) throws InterruptedException {

        jobTitle.click();

        Thread.sleep(2000);

        java.util.List<WebElement> options =
                driver.findElements(
                        By.xpath("//div[contains(@class,'oxd-select-option')]"));

        System.out.println("===== JOB TITLE OPTIONS =====");

        for (WebElement option : options) {

            System.out.println(option.getText());
        }

        System.out.println("============================");
    }

    public void enterDescription(String text) {

        description.sendKeys(text);
    }

    public void selectHiringManager(String manager) throws InterruptedException {

        hiringManager.click();

        hiringManager.sendKeys(manager);

        Thread.sleep(2000);

        WebElement option = driver.findElement(
                By.xpath("//div[contains(@class,'oxd-autocomplete-option')]"
                        + "//span[normalize-space()='" + manager + "']"));

        option.click();
    }
    public void enterNumberOfPositions(String number) {

        numberOfPositions.clear();
        numberOfPositions.sendKeys(number);
    }

    public void save() {

        saveButton.click();
    }

    public void createVacancy(
            String name,
            String title,
            String desc,
            String manager,
            String positions) throws InterruptedException {

        enterVacancyName(name);
        selectJobTitle(title);
        enterDescription(desc);
        selectHiringManager(manager);
        enterNumberOfPositions(positions);
        
    
    }
    
    public void verifyVacancyDetails() {

        System.out.println("Hiring Manager: " +
                hiringManager.getAttribute("value"));

        System.out.println("Number of Positions: " +
                numberOfPositions.getAttribute("value"));
    }
}
