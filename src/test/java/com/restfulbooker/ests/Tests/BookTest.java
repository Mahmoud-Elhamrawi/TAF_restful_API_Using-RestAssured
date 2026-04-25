package com.restfulbooker.ests.Tests;

import com.restfulBooker.API.BookReq;
import com.restfulBooker.Models.BookPOJO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tools.jackson.databind.ObjectMapper;

import static com.restfulBooker.API.BookReq.*;
import static com.restfulBooker.Steps.BookData.*;
import static com.restfulBooker.Steps.UserData.getToken;

public class BookTest {
    @Test(description = "create new book with valid data")
    public void CreateNewBookTC() {
        BookPOJO bookPOJO = createNewBookData();

        System.out.println(new ObjectMapper().writeValueAsString(bookPOJO));
        //req
        Response res = createNewBookReq(bookPOJO);

        //assert
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertEquals(res.body().jsonPath().get("booking.firstname"), bookPOJO.getFirstname());
        Assert.assertEquals(res.body().jsonPath().get("booking.additionalneeds"), bookPOJO.getAdditionalNeeds());
        Assert.assertEquals(res.body().jsonPath().get("booking.bookingdates.checkin"), bookPOJO.getBookingdates().getCheckin());
    }

    @Test(description = "not able to create a new book with missing  data")
    public void inValidCreateNewBookTC() {
        BookPOJO bookPOJO = createNewBookWithMissingData();

        System.out.println(new ObjectMapper().writeValueAsString(bookPOJO));
        //req
        Response res = createNewBookReq(bookPOJO);

        //assert
        Assert.assertEquals(res.statusCode(), 500);
        Assert.assertEquals(res.asString(), "Internal Server Error");
    }


    @Test(description = "get book by id")
    public void getBookByIdTC() {

        BookPOJO bookPOJO = createNewBookData();

        int bookID = getBookId(bookPOJO);

        //req
        Response res = BookReq.getBookReq(bookID);

        //assert
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertEquals(res.body().jsonPath().get("firstname"), bookPOJO.getFirstname());
    }

    @Test(description = "update book by id")
    public void updateBookByIdTC() {
        BookPOJO bookPOJO = createNewBookData();
        System.out.println(new ObjectMapper().writeValueAsString(bookPOJO));
        int bookID = getBookId(bookPOJO);
        System.out.println(bookID);


        BookPOJO bookPOJO1 = new BookPOJO("Firsttest", "Lasttest", bookPOJO.getTotalPrice(), bookPOJO.getDepositPaid(), bookPOJO.getBookingdates(), bookPOJO.getAdditionalNeeds());
        System.out.println(new ObjectMapper().writeValueAsString(bookPOJO1));


        String token = getToken();
        //req
        Response res = updateBookReq(bookID, bookPOJO1, token);
        //assert
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertEquals(res.body().jsonPath().get("firstname"), bookPOJO1.getFirstname());
        Assert.assertEquals(res.body().jsonPath().get("lastname"), bookPOJO1.getLastname());
        Assert.assertEquals(res.body().jsonPath().get("totalprice"), bookPOJO1.getTotalPrice());

    }


    @Test(description = "delete book by id")
    public void deleteBookByIdTC() {
        BookPOJO bookPOJO = createNewBookData();
        int bookID = getBookId(bookPOJO);

        String token = getToken();

        //req
        Response res = deleteBookReq(bookID, token);

        //assert
        Assert.assertEquals(res.statusCode(), 201);
        Assert.assertEquals(res.asString(), "Created");
    }

    @Test(description = "get book after deleted")
    public void getBookAfterDeletedTC() {
        BookPOJO bookPOJO = createNewBookData();
        int bookID = getBookId(bookPOJO);

        String token = getToken();

        //req
        Response res = deleteBookReq(bookID, token);
        Response res2 = getBookReq(bookID);

        //assert
        Assert.assertEquals(res2.statusCode(), 404);
        Assert.assertEquals(res2.asString(), "Not Found");
    }

}

