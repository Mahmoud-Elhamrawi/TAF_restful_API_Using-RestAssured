package com.restfulBooker.Steps;

import com.github.javafaker.Faker;
import com.restfulBooker.API.createToken;
import com.restfulBooker.Models.UserPOJO;
import io.restassured.response.Response;
import tools.jackson.databind.ObjectMapper;

import static com.restfulBooker.API.createToken.createUserReq;

public class UserData {

    public static UserPOJO createNewUserData() {
        Faker faker = new Faker();
        String userName = faker.name().username();
        String password = faker.internet().password(8, 16);
        return new UserPOJO(userName, password);
    }

    public static String getToken()
    {
        UserPOJO userPOJO = new UserPOJO("admin", "password123");
        Response res = createToken.createUserReq(userPOJO);
        return res.body().jsonPath().get("token");

    }







}
