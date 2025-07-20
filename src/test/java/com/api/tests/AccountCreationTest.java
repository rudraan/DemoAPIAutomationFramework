package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description="Verify if account is created")
    public void createAccountTest(){
//Builder is a static class so call by class name
// Builder pattern is used to avoid the constructor complexity of passing the parameters in sequence
        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .userName("software")
                .email("software@gmail.com")
                .firstName("Hard")
                .password("Hard12345")
                .lastName("Ware")
                .mobileNumber("6799543210").build();
        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        //System.out.println(response.asPrettyString());
        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
        Assert.assertEquals(response.statusCode(),200);
    }
}
