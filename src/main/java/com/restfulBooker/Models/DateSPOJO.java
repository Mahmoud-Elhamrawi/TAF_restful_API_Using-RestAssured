package com.restfulBooker.Models;

public class DateSPOJO {
    private String checkin;
    private String checkout;

    public DateSPOJO() {}

    public DateSPOJO(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }


    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

}
