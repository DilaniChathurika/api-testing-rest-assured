import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
public class checklist extends login{

    @Test(priority = 1)
    void getchecklist(){

        given()
                .contentType("application/json")

                .when()
                .get("https://dummyapi.io/checklist")

                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 2)
    void updatechecklist(){
        HashMap <String,Object> data=new HashMap<>();
        data.put("is_completed",true);

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(data)

                .when()
                .put("https://dummyapi.io/users/api/v1/csm/dummyvisits/6/dymmychecklist/17")

                .then()
                .statusCode(200)
                .log().all();

    }
}
