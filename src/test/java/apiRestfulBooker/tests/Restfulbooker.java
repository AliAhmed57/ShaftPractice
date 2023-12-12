package apiRestfulBooker.tests;

import apiRestfulbooker.objects.Apis;
import apiRestfulbooker.objects.ApisBooking;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Restfulbooker {
    private SHAFT.API api;
    private ApisBooking apisBooking;


    /////////// Configurations \\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        api = new SHAFT.API("https://restful-booker.herokuapp.com");
        apisBooking = new ApisBooking(api);
        Apis.login(api, "admin", "password123");
    }
    //////////// Tests \\\\\\\\\\\\
    @Test
    public void deleteBookingTest()
    {

        apisBooking.deleteBooking();
    }



}
