package lesson7;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetAllEmployeesTest {

    private final String BASEURL = "https://technokrater-api.cloud.technokratos.com/employee-service";
    private final String GET_EMPLOYEES_ENDPOINT = "/api/employees";
    private final String TEST_USER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpZCI6IjIxOSIsImVtYWlsIjoidGVzdEB0ZWNobm9rc" +
            "mF0b3MuY29tIiwicm9sZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BRE1JTiIsIlJPTEVfT05CT0FSRElOR19BRE1JTiIsIlJPTEVfVVNFU" +
            "l9DUkVBVEUiLCJST0xFX0RPQ1VNRU5UU19BQ0NFU1MiLCJST0xFX1BST0ZJTEVfVVBEQVRFIiwiUk9MRV9DQVJfQUNDRVNTIiwiUk9MR" +
            "V9TRUFSQ0giLCJST0xFX0ZJUkVfRU1QTE9ZRUUiLCJST0xFX0hSIiwiUk9MRV9BVFRFU1RBVElPTl9DUkVBVEUiLCJST0xFX1NUQUZGX" +
            "0RFUEFSVE1FTlQiLCJST0xFX1ZBQ0FUSU9OX0NPTlRST0wiLCJST0xFX0FUVEVTVEFUSU9OX0FETUlOIl19.fNetlD254R5HeGGMHrtE" +
            "KydOMKbga88ciQ51ghtBRgg";

    @Test
    public void getAllEmployeesValidateSchema() {
        Response getEmployees = given()
                .baseUri(BASEURL)
                .basePath(GET_EMPLOYEES_ENDPOINT)
                .relaxedHTTPSValidation()
                .header("authorization", TEST_USER_TOKEN)
                .when()
                .get();

        getEmployees.then().body(matchesJsonSchemaInClasspath("get-all-employees-schema.json"));
    }
}
