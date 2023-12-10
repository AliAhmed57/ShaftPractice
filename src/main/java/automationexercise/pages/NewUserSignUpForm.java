package automationexercise.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserSignUpForm {
    private SHAFT.GUI.WebDriver driver ;

    public NewUserSignUpForm(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By signup_name = By.name("name") ;
    private final By signup_email = By.xpath("(//input[@data-qa ='signup-email'])");
    private final By signup_Button = By.xpath("(//button[@data-qa='signup-button'])") ;
    // Actions
    public void signUpform(String name , String email)
    {
        driver.element().type(signup_name,name);
        driver.element().type(signup_email,email);
        driver.element().click(signup_Button);
    }


}
