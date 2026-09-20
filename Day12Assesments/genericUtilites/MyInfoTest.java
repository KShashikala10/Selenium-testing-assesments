package testScripts;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import pomImplementation.LoginPage;
import pomImplementation.MyInfoPage;

public class MyInfoTest extends BaseClass {

    @Test
    public void updateEmployeeDetailsTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        MyInfoPage myInfo = new MyInfoPage(driver);

        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        // =========================
        // 1. LOGIN
        // =========================

        login.login(username, password);

        // =========================
        // 2. CLICK MY INFO
        // =========================

        myInfo.clickMyInfo();

        // =========================
        // 3. UPDATE DETAILS
        // =========================

        String expectedFirstName = "Shashi";
        String expectedLastName = "K";
        String expectedEmployeeId = "EMP001";

        myInfo.editEmployeeDetails(
                expectedFirstName,
                expectedLastName,
                expectedEmployeeId
        );
        System.out.println(
                "After Save First Name: " +
                myInfo.getFirstName());

        System.out.println(
                "After Save Last Name: " +
                myInfo.getLastName());

        System.out.println(
                "After Save Employee ID: " +
                myInfo.getEmployeeId());

        System.out.println("Employee details updated");

        // =========================
        // 4. LOGOUT
        // =========================

        login.logout();

        System.out.println("Logged out successfully");

        // =========================
        // 5. LOGIN AGAIN
        // =========================

        login.login(username, password);

        System.out.println("Logged in again successfully");

        // =========================
        // 6. MY INFO AGAIN
        // =========================

        myInfo.clickMyInfo();

        // =========================
        // 7. VERIFY DETAILS
        // =========================

        String actualFirstName = myInfo.getFirstName();
        String actualLastName = myInfo.getLastName();
        String actualEmployeeId = myInfo.getEmployeeId();

        System.out.println(
                "Expected First Name: " + expectedFirstName);

        System.out.println(
                "Actual First Name: " + actualFirstName);

        System.out.println(
                "Expected Last Name: " + expectedLastName);

        System.out.println(
                "Actual Last Name: " + actualLastName);

        System.out.println(
                "Expected Employee ID: " + expectedEmployeeId);

        System.out.println(
                "Actual Employee ID: " + actualEmployeeId);

        // =========================
        // 8. VERIFY
        // =========================

        if (actualFirstName.equals(expectedFirstName)) {

            System.out.println(
                    "PASS: First Name is updated");

        } else {

            System.out.println(
                    "FAIL: First Name is not updated");
        }

        if (actualLastName.equals(expectedLastName)) {

            System.out.println(
                    "PASS: Last Name is updated");

        } else {

            System.out.println(
                    "FAIL: Last Name is not updated");
        }

        if (actualEmployeeId.equals(expectedEmployeeId)) {

            System.out.println(
                    "PASS: Employee ID is updated");

        } else {

            System.out.println(
                    "FAIL: Employee ID is not updated");
        }

        // =========================
        // 9. LOGOUT
        // =========================

        login.logout();

        System.out.println(
                "Logged out successfully");

        System.out.println(
                "========== TEST COMPLETED ==========");
    }
}
