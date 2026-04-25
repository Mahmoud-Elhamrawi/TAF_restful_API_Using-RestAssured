package com.restfulbooker.ests.Tests;

import com.restfulBooker.Models.MessagePOJO;
import com.restfulBooker.Models.UserPOJO;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import tools.jackson.databind.ObjectMapper;

import static com.restfulBooker.API.createToken.createUserReq;
import static com.restfulBooker.Steps.UserData.createNewUserData;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class UserTest {
    @Test
    public void validRegistrationTC() {

        UserPOJO userPOJO = new UserPOJO("admin", "password123");
        System.out.println(new ObjectMapper().writeValueAsString(userPOJO));

        //Req
        Response res = createUserReq(userPOJO);

        //de-ser
        UserPOJO returnedData = res.body().as(UserPOJO.class);

        //assert
        assertThat(res.statusCode(), equalTo(200));
        assertThat(returnedData.getToken(), not(equalTo(null)));


    }


    @Test(description = "registration with invalid data")
    public void inValidRegistrationTC() {

        UserPOJO userPOJO = createNewUserData();

        System.out.println(new ObjectMapper().writeValueAsString(userPOJO));

        //Req
        Response res = createUserReq(userPOJO);

        //de-ser
        UserPOJO returnedData = res.body().as(UserPOJO.class);
        MessagePOJO message = res.body().as(MessagePOJO.class);

        //assert
        assertThat(res.statusCode(), equalTo(200));
        assertThat(message.getReason(), equalTo("Bad credentials"));


    }

}
