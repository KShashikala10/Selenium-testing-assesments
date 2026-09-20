package testScripts;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import pomImplementation.LoginPage;
import pomImplementation.RecruitmentPage;

public class RecruitmentTest extends BaseClass {

    @Test
    public void createVacancyTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);

        RecruitmentPage recruitment =
                new RecruitmentPage(driver);

        // Login
        login.login(
                prop.getProperty("username"),
                prop.getProperty("password"));

        // Recruitment
        recruitment.clickRecruitment();

        // Vacancies
        recruitment.clickVacancies();

        // Add
        recruitment.clickAdd();

        // Create vacancy
        recruitment.createVacancy(
                "Data Analyst",
                "Data Engineer",
                "Data analytics vacancy",
                "Dora Ali",
                "3"
        );

        recruitment.verifyVacancyDetails();
    }
}
