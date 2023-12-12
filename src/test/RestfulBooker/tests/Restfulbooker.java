package RestfulBooker.tests;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Restfulbooker {
    public String tokenValue ;
    public int bookingidValue ;
    SHAFT.API api;
    // Status Codes
    private final int success_statusCode = 200;
    private final int successDelete_statusCode = 201;


    // Services names
    private final String authentication_serviceName = "/auth";
    private final String booking_serviceName = "/booking";

    /////////// Configurations \\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        api = new SHAFT.API("https://restful-booker.herokuapp.com");
    }
    //////////// Tests \\\\\\\\\\\\
    @Test
    public void deleteBooking()
    {
        tokenValue = getTokenValue() ;
        bookingidValue = createBooking();
        deleteBooking(tokenValue , bookingidValue);
    }

    ////////////////// Business Methods | Actions \\\\\\\\\\\\\\\\\\\\\
    public String getTokenValue()
    {
        String tokenBody = """
                {
                    "username" : "admin",
                    "password" : "password123"
                }
                """;
        api.post(authentication_serviceName)
                .setContentType(ContentType.JSON)
                .setRequestBody(tokenBody)
                .setTargetStatusCode(200)
                .perform();

        api.assertThatResponse().body().contains("\"token\":").perform();
        tokenValue = api.getResponseJSONValue("token");
        return tokenValue;
    }

    public int createBooking()
    {
        String createBookingBody = """
                {
                    "firstname" : "Ali",
                    "lastname" : "Ahmed",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2023-01-01",
                        "checkout" : "2024-01-01"
                    },
                    "additionalneeds" : "Hot Chocolate"
                }
                """;
        api.post(booking_serviceName)
                .setContentType(ContentType.JSON)
                .setRequestBody(createBookingBody)
                .setTargetStatusCode(200)
                .perform();

        validateThatTheBookingIsCreated("Ali" , "Ahmed" , "Hot Chocolate");
        bookingidValue = Integer.parseInt(api.getResponseJSONValue("bookingid"));
        return bookingidValue ;
    }

    public void deleteBooking(String tokenValue , int bookingidValue)
    {
        api.delete(booking_serviceName+"/"+bookingidValue).setContentType(ContentType.JSON).addHeader("Cookie","token="+tokenValue).setTargetStatusCode(201).perform();
        validateThatTheBookingDeleted();
    }
    public void validateThatTheBookingIsCreated(String expectedFirstName, String expectedLastName, String expectedAdditionalNeeds) {
        api.verifyThatResponse().extractedJsonValue("booking.firstname").isEqualTo(expectedFirstName).perform();
        api.verifyThatResponse().extractedJsonValue("booking.lastname").isEqualTo(expectedLastName).perform();
        api.verifyThatResponse().extractedJsonValue("booking.additionalneeds").isEqualTo(expectedAdditionalNeeds).perform();
        api.verifyThatResponse().body().contains("\"bookingid\":").perform();
    }
    public void validateThatTheBookingDeleted() {
        api.assertThatResponse().body().isEqualTo("Created");

    }




}
