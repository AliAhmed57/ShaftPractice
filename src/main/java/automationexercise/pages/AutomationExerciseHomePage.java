package automationexercise.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AutomationExerciseHomePage {
    private SHAFT.GUI.WebDriver driver ;
    // Locators
    String automationExerciseHomePageurl = "https://automationexercise.com/" ;
    private final By homePageVerification_h2 = By.xpath("//div[@class='shop-menu pull-right']//ul//li//a[@href='/']");

    public AutomationExerciseHomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void navigatetoAutomationExerciseHomePage()
    {

        driver.browser().navigateToURL(automationExerciseHomePageurl);
    }
    // Validation
    public void verificationOnHomePage ()
    {
        driver.element().assertThat(homePageVerification_h2).text().isEqualTo("Home").perform();
    }




}
