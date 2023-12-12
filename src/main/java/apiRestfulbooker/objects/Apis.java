package apiRestfulbooker.objects;

import io.restassured.http.ContentType;
import com.shaft.driver.SHAFT;

public class Apis {
    private SHAFT.API api;
    public static String tokenValue;

    public Apis(SHAFT.API api) {
        this.api = api;
    }


    // Status Codes
    public static final int success_statusCode = 200;
    public static final int successDelete_statusCode = 201;
    // Services
    private static final String authentication_serviceName = "/auth";


    public static String login(SHAFT.API api,String username, String password) {
        String tokenBody = """
                {
                    "username" : "{USERNAME}",
                    "password" : "{PASSWORD}"
                }
                """
                .replace("{USERNAME}", username)
                .replace("{PASSWORD}", password);

        api.post(authentication_serviceName)
                .setContentType(ContentType.JSON)
                .setRequestBody(tokenBody)
                .setTargetStatusCode(success_statusCode)
                .perform();

        String tokenValue = api.getResponseJSONValue("token");

        api.addHeader("Cookie", "token=" + tokenValue);
        return tokenValue;
    }




}
