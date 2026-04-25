package com.restfulBooker.API;

import com.restfulBooker.Models.UserPOJO;
import com.restfulBooker.Routes.Endpoints;
import com.restfulBooker.Specs.Spec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class createToken {

    public static Response createUserReq(UserPOJO userPOJO) {
        return given()
                .spec(Spec.reqSpec())
                .body(userPOJO)
                .when().post(Endpoints.AUTH)
                .then().log().all()
                .extract().response();


    }


}
