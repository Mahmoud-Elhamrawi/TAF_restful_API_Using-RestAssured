package com.restfulBooker.Specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Spec {
    public static RequestSpecification reqSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON)
                .build();
    }
}
