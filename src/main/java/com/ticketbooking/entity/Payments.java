package com.ticketbooking.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name="payment")
public class Payments {

    @Id
    @Column(name="paymentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column(name="amount")
    private double amount;

    @Column(name="timeStamp")
    private Date timeStamp;

    @OneToOne
    @JoinColumn(name="bookingId")
    private Bookings bookings;


    public Payments(Double amount, Date timeStamp, Bookings bookings){
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.bookings = bookings;
    }

    public Payments(){

    }


}
