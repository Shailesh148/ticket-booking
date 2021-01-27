package com.ticketbooking.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(
        name="booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "bookingId")
    private int bookingId;

    @Column(name="timeStamp")
    private Date timeStamp;

    @Column(name="noOfSeats")
    private int noOfSeats;

    @ManyToOne
    @JoinColumn(name="id")
    private User user;

    @ManyToOne
    @JoinColumn(name="showId")
    private ShowEntity show;


    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public ShowEntity getShow() {
        return show;
    }

    public void setShow(ShowEntity show) {
        this.show = show;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookingEntity(Date timeStamp, int noOfSeats, User user, ShowEntity show){
        this.timeStamp = timeStamp;
        this.noOfSeats = noOfSeats;
        this.user = user;
        this.show = show;
    }

    public BookingEntity(){

    }
}
