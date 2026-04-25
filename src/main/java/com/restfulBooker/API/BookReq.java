package com.restfulBooker.API;

import com.restfulBooker.Models.BookPOJO;
import com.restfulBooker.Specs.Spec;
import io.restassured.response.Response;

import static com.restfulBooker.Routes.Endpoints.NEW_BOOKING;
import static io.restassured.RestAssured.given;

public class BookReq {

    public static Response createNewBookReq(BookPOJO bookPOJO) {
        return given()
                .spec(Spec.reqSpec())
                .body(bookPOJO)
                .when().post(NEW_BOOKING)
                .then().log().all()
                .extract().response();
    }


    public static Response getBookReq(int bookID) {
        return given()
                .spec(Spec.reqSpec())
                .when().get(NEW_BOOKING+"/"+bookID)
                .then().log().all()
                .extract().response();
    }

    public static Response updateBookReq(int bookID, BookPOJO bookPOJO, String token)
    {
        return given()
                .spec(Spec.reqSpec())
                .body(bookPOJO)
                .header("Cookie", "token=" + token)
                .when().put(NEW_BOOKING+"/"+bookID)
                .then().log().all()
                .extract().response();
    }


    public static Response deleteBookReq(int bookID, String token) {
        return given()
                .spec(Spec.reqSpec())
                .header("Cookie", "token=" + token)
                .when().delete(NEW_BOOKING+"/"+bookID)
                .then().log().all()
                .extract().response();
    }

}
