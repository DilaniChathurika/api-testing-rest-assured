import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class login {
    String token;
    @BeforeMethod
    void postlogin() {

        // Request body for login
        HashMap<String, Object> data = new HashMap<>();
        data.put("email", "Dilani@gmail.com");
        data.put("password", "Dilani@78");
        
        Response res =
                given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://dummyapi.io/api/v1/login");

        // Extract token from response JSON
        token = res.jsonPath().getString("token");

        // Print token for debugging
        System.out.println("Token received: " + token);

        // Validate login success
        res.then().log().all();
    }
}
