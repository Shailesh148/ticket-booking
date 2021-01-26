package com.ticketbooking.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name="payment")
public class PaymentEntity {

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
    private BookingEntity bookingEntity;


    public PaymentEntity(Double amount, Date timeStamp, BookingEntity bookingEntity){
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.bookingEntity = bookingEntity;
    }

    public PaymentEntity(){

    }


}
