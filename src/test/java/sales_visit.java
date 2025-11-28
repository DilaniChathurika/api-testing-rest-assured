import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;
import static sun.jvm.hotspot.utilities.AddressOps.greaterThan;

public class sales_visit extends login {

    private static final Logger log = LoggerFactory.getLogger(sales_visit.class);

    @Test
    void postuser() {
        // Prepare data for API request
        HashMap<String, Object> data = new HashMap<>();
        data.put("corporate_customer_id", 5);
        data.put("visit_date", "2025-12-05");
        data.put("visit_time", "11:00:00");
        data.put("objective", "No objective");
        data.put("checklist_template_id", 3);

        // Send request using stored token
        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://dummyapi.io/sales-visits")

                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    void getsalevisite(){
        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")

                .when()
                .get("https://dummyapi.io/sales-visits")

                .then()
                .statusCode(200)
                .body("data", notNullValue())
                .body("data[0]", hasKey("id"))
                .body("data[0]", hasKey("company_name"))
                .body("data[0]", hasKey("visit_date"))
                .body("data[0]", hasKey("visit_time"))
                .body("data[0]", hasKey("objective"))
                .body("data[0]", hasKey("status"))
                .body("meta.total", notNullValue())
                .log().all();
    }
    @Test
    void putsalevisit(){

        HashMap<String,Object> data=new HashMap<>();
        data.put("visit_date","2025-11-21");
        data.put("visit_time","15:00:00");
        data.put("objective","Updated: Finalize budget for");
        data.put("status","Completed");
        data.put("checklist_template_id",2);

        given()

                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(data);
                when()
                        .get("https://dummyapi.io/abc/sales-visits")
                .then()
                        .statusCode(200)
                        .log().all();

    }
}
