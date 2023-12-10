package automationexercise.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateAccount {
    private SHAFT.GUI.WebDriver driver ;

    public CreateAccount(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private final By createaccount_Button =  By.xpath("(//button [@data-qa = 'create-account'])");
    private final By createaccountMessage_h2 = By.xpath("(//h2[@class])//b");


    // Actions
    public void createAccount()
    {
        driver.element().click(createaccount_Button) ;

    }

    // Validation
    public void createAccountVerification()
    {
        driver.element().assertThat(createaccountMessage_h2).text().isEqualTo("ACCOUNT CREATED!");
    }
}
