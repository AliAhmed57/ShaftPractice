package apiRestfulbooker.objects;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

public class ApisBooking {
    private SHAFT.API api ;
    public static int bookingidValue ;
    public  String tokenValue ;

    // Services names
    private static final String booking_serviceName = "/booking";

    public ApisBooking(SHAFT.API api)
    {
        this.api = api ;
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
                .setTargetStatusCode(Apis.success_statusCode)
                .perform();

        validateThatTheBookingIsCreated("Ali" , "Ahmed" , "Hot Chocolate");
        bookingidValue = Integer.parseInt(api.getResponseJSONValue("bookingid"));
        return bookingidValue ;
    }

    /*public String getBookingId(String firstName, String lastName) {
        api.get(booking_serviceName)
                .setUrlArguments("firstname=" + firstName + "&lastname=" + lastName)
                .perform();
        return api.getResponseJSONValue("$[0].bookingid");
    }
    */

    public void deleteBooking()
    {
        api.delete(booking_serviceName+"/"+createBooking()).setContentType(ContentType.JSON).setTargetStatusCode(Apis.successDelete_statusCode).perform();
        validateThatTheBookingDeleted();
    }

    ////////// Validations \\\\\\\\\\\\\\\\\
    public void validateThatTheBookingIsCreated(String expectedFirstName, String expectedLastName, String expectedAdditionalNeeds) {
        api.verifyThatResponse().extractedJsonValue("booking.firstname").isEqualTo(expectedFirstName).perform();
        api.verifyThatResponse().extractedJsonValue("booking.lastname").isEqualTo(expectedLastName).perform();
        api.verifyThatResponse().extractedJsonValue("booking.additionalneeds").isEqualTo(expectedAdditionalNeeds).perform();
        api.verifyThatResponse().body().contains("\"bookingid\":").perform();
    }
    public  void validateThatTheBookingDeleted() {
        api.assertThatResponse().body().isEqualTo("Created");

    }


}
