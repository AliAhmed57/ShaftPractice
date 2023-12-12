package automationexercise.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver ;

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By login_name = (By.xpath("(//input[@data-qa='login-email'])"));
    private final By login_password = (By.name("password"));
    private final By login_Button = By.xpath("(//button[@data-qa='login-button'])") ;
    private final By username_id = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b");

    public void login(String email , String password)
    {
        driver.element().type(login_name,email);
        driver.element().type(login_password,password);
        driver.element().click(login_Button);
    }

    // Validations

    public void validateOnuser()
    {
        driver.element().assertThat(username_id).text().isEqualTo("Ali").perform();
    }

}
