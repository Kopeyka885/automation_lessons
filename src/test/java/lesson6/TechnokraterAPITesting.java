package lesson6;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TechnokraterAPITesting {

    private final String BASEURL = "https://technokrater-api.cloud.technokratos.com/employee-service";
    private final String TEST_USER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpZCI6IjIxOSIsImVtYWlsIjoidGVzdEB0ZWNobm9rc" +
            "mF0b3MuY29tIiwicm9sZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BRE1JTiIsIlJPTEVfT05CT0FSRElOR19BRE1JTiIsIlJPTEVfVVNFU" +
            "l9DUkVBVEUiLCJST0xFX0RPQ1VNRU5UU19BQ0NFU1MiLCJST0xFX1BST0ZJTEVfVVBEQVRFIiwiUk9MRV9DQVJfQUNDRVNTIiwiUk9MR" +
            "V9TRUFSQ0giLCJST0xFX0ZJUkVfRU1QTE9ZRUUiLCJST0xFX0hSIiwiUk9MRV9BVFRFU1RBVElPTl9DUkVBVEUiLCJST0xFX1NUQUZGX" +
            "0RFUEFSVE1FTlQiLCJST0xFX1ZBQ0FUSU9OX0NPTlRST0wiLCJST0xFX0FUVEVTVEFUSU9OX0FETUlOIl19.fNetlD254R5HeGGMHrtE" +
            "KydOMKbga88ciQ51ghtBRgg";
    private final String COMMON_USER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpZCI6IjMxMCIsImVtYWlsIjoiay5rYWR5cm92QH" +
            "RlY2hub2tyYXRvcy5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiXX0.cdYBgEVmrgIc3VXLLPay0MSoPf9EVD5JIfW0id3og4c";

    private HashMap user;
    private int maxId;
    private int responseId = -1;
    private final String CREATE_EMPLOYEE_ENDPOINT = "/api/users/create";
    private final String GET_EMPLOYEES_ENDPOINT = "/api/employees";
    private final String PATCH_SET_USER_ROLES_ENDPOINT = "/api/users/{id}/roles";

    @BeforeClass(groups = {"getMethod"})
    public void prepareUser() {
        System.out.println("Prepare User");

        Response getEmployees = given()
                .baseUri(BASEURL)
                .basePath(GET_EMPLOYEES_ENDPOINT)
                .relaxedHTTPSValidation()
                .header("authorization", TEST_USER_TOKEN)
                .when()
                .get();

        maxId = getEmployees.getBody().jsonPath().getJsonObject("id.max()");

        user = new HashMap();
        user.put("departmentId", 3);
        user.put("directorId", 145);
        user.put("email", "qa_automation_test_user_" + maxId + "@technokratos.com");
        user.put("firstName", "Балуются");
        user.put("hrId", 145);
        user.put("isTrainee", false);
        user.put("lastName", "Тестировщики");
        user.put("patronymic", "Автоматизацией");
        user.put("phoneNumber", "+79999999999");
        user.put("positionId", 3);
        user.put("startDate", "2022-05-06");
        user.put("teamId", 3);
        user.put("telegram", "qaqaqaqaqa");
        user.put("toShowPatronymic", true);
        user.put("workStatus", "IN_OFFICE");

    }

    @Test(groups = {"postMethod"})
    public void testCreateUser() {

        Response postTest = given()
                .baseUri(BASEURL)
                .basePath(CREATE_EMPLOYEE_ENDPOINT)
                .relaxedHTTPSValidation()
                .header("content-type", ContentType.JSON)
                .header("authorization", TEST_USER_TOKEN)
                .body(user)
                .when()
                .post();

        postTest.then().statusCode(200);
        postTest.then().body("id", equalTo(maxId));
        responseId = postTest.body().jsonPath().getJsonObject("id");
    }

    @Test(groups = {"postMethod"})
    public void createUserWithoutToken() {
        Response postTest = given()
                .baseUri(BASEURL)
                .basePath(CREATE_EMPLOYEE_ENDPOINT)
                .relaxedHTTPSValidation()
                .header("content-type", ContentType.JSON)
//                .header("authorization", TOKEN)
                .body(user)
                .when()
                .post();

        postTest.then().statusCode(401);
    }

    @Test(groups = {"postMethod"})
    public void createUserWithTokenWithoutNeededPermissions() {
        Response postTest = given()
                .baseUri(BASEURL)
                .basePath(CREATE_EMPLOYEE_ENDPOINT)
                .relaxedHTTPSValidation()
                .header("content-type", ContentType.JSON)
                .header("authorization", COMMON_USER_TOKEN)
                .body(user)
                .when()
                .post();

        postTest.then().statusCode(403);
    }

    @Test(groups = {"getMethod"})
    public void getEmployeesWithCorrectParameters() {
        Response getResponse = given()
                .relaxedHTTPSValidation()
                .header("authorization", COMMON_USER_TOKEN)
                .baseUri(BASEURL)
                .basePath(GET_EMPLOYEES_ENDPOINT)
                .when()
                .get();

        getResponse.then().statusCode(200);

    }

    @Test(groups = {"getMethod"}, dependsOnMethods = "testCreateUser")
    public void checkCreatedUser() {
        Response getResponse = given()
                .relaxedHTTPSValidation()
                .header("authorization", COMMON_USER_TOKEN)
                .baseUri(BASEURL)
                .basePath(GET_EMPLOYEES_ENDPOINT)
                .when()
                .get();

        getResponse.then().statusCode(200);
        getResponse.then().body("max{it.id}.email", equalTo(user.get("email")));
        getResponse.then().body("max{it.id}.id", equalTo(responseId));
        getResponse.then().body("max{it.id}.workStatus", equalTo(user.get("workStatus")));
        getResponse.then().body("max{it.id}.phoneNumber", equalTo(user.get("phoneNumber")));
        getResponse.then().body("max{it.id}.telegram", equalTo(user.get("telegram")));
    }

    @Test(groups = "patchMethod")
    public void assignRoleToUserSuccessfully(){
        HashMap requestBody = new HashMap();
        ArrayList<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        requestBody.put("roles", roles);
        int id = 312;

        Response patchResponse = given()
                .baseUri(BASEURL)
                .basePath(PATCH_SET_USER_ROLES_ENDPOINT)
                .relaxedHTTPSValidation()
                .header("authorization", TEST_USER_TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .pathParam("id", id)
                .when()
                .patch();

        patchResponse.then().statusCode(200);
        patchResponse.then().body("id", equalTo(id));
        patchResponse.then().body("roles", equalTo(roles));
    }

    @Test(groups = "patchMethod")
    public void assignRoleToUncreatedUser(){
        HashMap requestBody = new HashMap();
        ArrayList<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        requestBody.put("roles", roles);
        int id = -1;

        Response patchResponse = given()
                .baseUri(BASEURL)
                .basePath(PATCH_SET_USER_ROLES_ENDPOINT)
                .relaxedHTTPSValidation()
                .header("authorization", TEST_USER_TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .pathParam("id", id)
                .when()
                .patch();

        patchResponse.then().statusCode(404);
    }

    @Test(groups = "patchMethod")
    public void assignRoleWithTokenWithoutNeededPermissions(){
        HashMap requestBody = new HashMap();
        ArrayList<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        requestBody.put("roles", roles);
        int id = -1;

        Response patchResponse = given()
                .baseUri(BASEURL)
                .basePath(PATCH_SET_USER_ROLES_ENDPOINT)
                .relaxedHTTPSValidation()
                .header("authorization", COMMON_USER_TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .pathParam("id", id)
                .when()
                .patch();

        patchResponse.then().statusCode(403);
    }
}
