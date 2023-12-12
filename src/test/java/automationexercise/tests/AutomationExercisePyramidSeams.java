package automationexercise.tests;

import automationexercise.pages.*;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AutomationExercisePyramidSeams {
    SHAFT.GUI.WebDriver driver ;
    SHAFT.TestData.JSON testdata ;
    private AutomationExerciseHomePage automationExerciseHomePage ;
    private NavigateToLoginPage navigateToSignupPage ;
    private LoginPage login ;

    @BeforeClass
    public void beforeclass()
    {
        testdata = new SHAFT.TestData.JSON("src/test/resources/Test Data/TestData.json");
    }
    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        automationExerciseHomePage = new AutomationExerciseHomePage(driver);
        automationExerciseHomePage.navigatetoAutomationExerciseHomePage();
        navigateToSignupPage = new NavigateToLoginPage(driver);
        login = new LoginPage(driver);

    }
    @Test
    public void test()
    {
        automationExerciseHomePage.verificationOnHomePage ();
        navigateToSignupPage.navigatetoSignUpPage();
        navigateToSignupPage.validateOnSignUpPage();
        login.login(testdata.getTestData("email"),testdata.getTestData("accountDetails.Password"));
        login.validateOnuser();

    }
    @AfterMethod
    public void aftermethod()
    {
        driver.quit();
    }




}
