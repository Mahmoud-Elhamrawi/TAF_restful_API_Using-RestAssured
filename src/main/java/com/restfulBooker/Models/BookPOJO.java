package com.restfulBooker.Models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookPOJO {
    private String firstname;
    private String lastname;

    @JsonProperty("totalprice")
    private Integer totalPrice;

    @JsonProperty("depositpaid")
    private Boolean depositPaid;

    @JsonProperty("bookingdates")
    private DateSPOJO bookingdates;

    @JsonProperty("additionalneeds")
    private String additionalNeeds;



    //Constructor
    public BookPOJO(String firstname, String lastname, Integer totalPrice,
                    Boolean depositPaid, DateSPOJO bookingdates, String additionalNeeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingdates = bookingdates;
        this.additionalNeeds = additionalNeeds;
    }

    public BookPOJO(String firstname, String lastname, Integer totalPrice,
                     DateSPOJO bookingdates, String additionalNeeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalPrice = totalPrice;
        this.bookingdates = bookingdates;
        this.additionalNeeds = additionalNeeds;
    }


    public BookPOJO(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public BookPOJO() {}

    // Getters
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public Integer getTotalPrice() { return totalPrice; }
    public Boolean getDepositPaid() { return depositPaid; }
    public DateSPOJO getBookingdates() { return bookingdates; }
    public String getAdditionalNeeds() { return additionalNeeds; }

}
