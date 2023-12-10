package automationexercise.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpPage {
    private SHAFT.GUI.WebDriver driver ;
    public SignUpPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By titleinformation_h2 = By.xpath("(//div[@class='single-widget'])//h2") ;
    private final By title_id = By.id("id_gender1") ;
    private final By password_id = By.id("password");
    /*private By day_select(String day) {
        return By.xpath("(//select [@data-qa = 'days'])//option [@value = ' " + day + "']");
    }
    */
    private final By day_select = By.xpath("(//select [@data-qa = 'days'])//option [@value = '14']");

    private final By month_select = By.xpath("(//select [@data-qa = 'months'])//option [@value = '1']");
    private final By year_select = By.xpath("(//select [@data-qa = 'years'])//option [@value = '2001']");

    private final By newsteller_input = By.xpath("(//input [@name ='newsletter'])") ;
    private final By optin_input = By.xpath("(//input [@name ='optin'])") ;
    private final By firstname_id = By.id("first_name") ;
    private final By lastname_id = By.id("last_name") ;
    private final By company_id = By.id("company") ;
    private final By address1_id = By.id("address1");
    private final By address2_id = By.id("address2") ;
    private final By country_select = By.xpath("(//select [@data-qa = 'country'])//option [@value = 'United States']");
    private final By state_id = By.id("state") ;

    private final By city_id = By.id("city") ;
    private final By zipcode_id = By.id("zipcode");
    private final By mobilenum_id = By.id("mobile_number");


    // Actions
    public void verificationAccountInformationPage()
    {
        driver.element().assertThat(titleinformation_h2).text().isEqualTo("SUBSCRIPTION").perform();
    }
    public void accountInformationDetails(String password , Boolean newsteller , Boolean optin)
    {
        driver.element().click(title_id);
        driver.element().type(password_id,password);
        driver.element().click(day_select);
        driver.element().click(month_select);
        driver.element().click(year_select);

        if (newsteller)
        {
            driver.element().click(newsteller_input);
        }
        if (optin)
        {
            driver.element().click(optin_input);
        }
    }
    public void addressInformationDetails(String firstName , String lastName , String company , String address1 , String address2 , String state , String city , String zipcode , String mobilenum)
    {
        driver.element().type(firstname_id,firstName);
        driver.element().type(lastname_id,lastName);
        driver.element().type(company_id,company);
        driver.element().type(address1_id,address1);
        driver.element().type(address2_id,address2);
        driver.element().click(country_select);
        driver.element().type(state_id,state);
        driver.element().type(city_id,city);
        driver.element().type(zipcode_id,zipcode);
        driver.element().type(mobilenum_id,mobilenum);
    }






}
