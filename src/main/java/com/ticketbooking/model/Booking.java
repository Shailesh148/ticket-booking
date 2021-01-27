package com.ticketbooking.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class Booking {

    private int showId;
    private String userName;
    private int noOfSeats;
    private Payment payment;


    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getUserId() {
        return userName;
    }

    public void setUserId(String userId) {
        this.userName = userName;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
