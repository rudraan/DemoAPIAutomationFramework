package com.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginAPITest2 {

    @Test(description="Verify if login API is working")
    public void loginTest(){
        Response response = given()
                .baseUri("http://64.227.160.186:8080")
                .headers("Content-Type","application/json")
                .body("{\n" +
                "  \"username\": \"facetime\",\n" +
                "  \"password\": \"pass1234\"\n" +
                "}").post("/api/auth/login");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);
    }
}
