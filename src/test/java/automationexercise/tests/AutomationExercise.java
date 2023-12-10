package automationexercise.tests;

import automationexercise.pages.*;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationExercise {

    SHAFT.GUI.WebDriver driver ;
    SHAFT.TestData.JSON testdata ;
    private AutomationExerciseHomePage automationExerciseHomePage ;
    private NavigateToLoginPage navigateToSignupPage ;

    private NewUserSignUpForm newUserSignUpForm;
    private SignUpPage signUpPage ;
    private CreateAccount createAccount ;

    @BeforeClass
    public void beforeclass()
    {
        testdata = new SHAFT.TestData.JSON("src/test/resources/Test Data/TestData.json");
    }
    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        automationExerciseHomePage = new AutomationExerciseHomePage(driver) ;
        automationExerciseHomePage.navigatetoAutomationExerciseHomePage();
        navigateToSignupPage = new NavigateToLoginPage(driver) ;
        newUserSignUpForm = new NewUserSignUpForm(driver) ;


        signUpPage = new SignUpPage(driver) ;
        createAccount = new CreateAccount(driver);
    }

    @Test
    public void test()
    {
        automationExerciseHomePage.verificationOnHomePage ();
        navigateToSignupPage.navigatetoSignUpPage();
        navigateToSignupPage.validateOnSignUpPage();
        newUserSignUpForm.signUpform(testdata.getTestData("username") , testdata.getTestData("email"));
        signUpPage.verificationAccountInformationPage() ;
        signUpPage.accountInformationDetails(testdata.getTestData("accountDetails.Password"), true , true );
        signUpPage.addressInformationDetails(testdata.getTestData("addressInformation.firstname") , testdata.getTestData("addressInformation.lastname") , testdata.getTestData("addressInformation.company") , testdata.getTestData("addressInformation.address1"), testdata.getTestData("addressInformation.address2") , testdata.getTestData("addressInformation.state") , testdata.getTestData("addressInformation.city") , testdata.getTestData("addressInformation.zipcode") , testdata.getTestData("addressInformation.mobileNum"));
        createAccount.createAccount() ;
        createAccount.createAccountVerification() ;
    }
    @AfterMethod
    public void aftermethod()
    {
        driver.quit();
    }


}
