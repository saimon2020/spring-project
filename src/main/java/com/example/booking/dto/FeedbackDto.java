package com.example.booking.dto;

import com.example.booking.entity.Booking;
import com.example.booking.enums.Rate;

public class FeedbackDto {
    private int id;
    private Rate rate;
    private String comment;
    private Booking booking;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
