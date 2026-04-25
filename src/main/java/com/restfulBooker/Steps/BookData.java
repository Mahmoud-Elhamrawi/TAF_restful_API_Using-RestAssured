package com.restfulBooker.Steps;

import com.github.javafaker.Faker;
import com.restfulBooker.API.BookReq;
import com.restfulBooker.Models.BookPOJO;
import com.restfulBooker.Models.DateSPOJO;
import io.restassured.response.Response;

import java.util.Optional;

public class BookData {

    public static BookPOJO createNewBookData() {

        DateSPOJO dates = new DateSPOJO("1991-10-28", "2026-12-31");

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int totalPrice = 2023;
        Boolean depositPaid = true;
        String additionalNeeds = "Breakfast and dinner";
        return new BookPOJO(firstName, lastName, totalPrice, depositPaid,dates, additionalNeeds);

    }


    public static BookPOJO createNewBookWithMissingData() {
        DateSPOJO dates = new DateSPOJO("1991-10-28", "2026-12-31");

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int totalPrice = 2023;
        String additionalNeeds = "Breakfast and dinner";
        return new BookPOJO(firstName, lastName, totalPrice,dates, additionalNeeds);

    }

    public static int getBookId(BookPOJO bookPOJO) {

        Response res = BookReq.createNewBookReq(bookPOJO);
        System.out.println(Optional.ofNullable(res.body().jsonPath().get("bookingid")));
        return res.body().jsonPath().get("bookingid");

    }


}


