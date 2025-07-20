package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test(description = "verify update profile API is working")
    public void updateProfileTest(){

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("facetime","pass1234"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());

        System.out.println("-------------------------------------------");

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfiles(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(),"facetime");

        System.out.println("-------------------------------------------");

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("Pawani")
                .lastName("Mirabilia")
                .email("mira@gmail.com")
                .mobileNumber("9978654210")
                .build();
        response = userProfileManagementService.updateProfiles(loginResponse.getToken(), profileRequest);
        System.out.println(response.asPrettyString());

    }
}
