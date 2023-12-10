package automationexercise.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NavigateToLoginPage {
    private SHAFT.GUI.WebDriver driver ;

    public NavigateToLoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private final By signup_a =By.xpath("(//a [@href='/login'])");
    private final By signup_form = By.className("signup-form");
    // Actions
    public void navigatetoSignUpPage()
    {
        driver.element().click(signup_a);
    }
    // Validations
    public void validateOnSignUpPage()
    {
        driver.element().assertThat(signup_form).text().isEqualTo("New User Signup!");
    }

}
