package com.ticketbooking.service;


import com.ticketbooking.entity.BookingEntity;
import com.ticketbooking.entity.MovieEntity;
import com.ticketbooking.entity.PaymentEntity;
import com.ticketbooking.entity.ShowEntity;
import com.ticketbooking.model.Booking;
import com.ticketbooking.model.Payment;
import com.ticketbooking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
public class BookingService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    UserRepository userRepository;

    public List<ShowEntity> getAllShows(){
        List<ShowEntity> allShows = showRepository.findAll();
        return allShows;
    }

    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<ShowEntity> getShowsForMovie(int movie){
        return showRepository.findByMovieMovieId(movie);
    }

    public void bookShow(Booking booking){
        Payment payment = booking.getPayment();
        BookingEntity bookingEntity = new BookingEntity(new Date(), booking.getNoOfSeats(),userRepository.findById(booking.getUserId()).get(), showRepository.findById(booking.getShowId()).get());
        PaymentEntity paymentEntity = new PaymentEntity(payment.getAmount(), new Date(),bookingEntity);
        transact(bookingEntity, paymentEntity);
    }

    @Transactional
    public void transact(BookingEntity bookingEntity, PaymentEntity paymentEntity){
        bookingRepository.save(bookingEntity);
        paymentRepository.save(paymentEntity);
    }

    public List<BookingEntity> getUserBookings(int userId){
        List<BookingEntity> bookings = bookingRepository.findByUserId(userId);
        for (BookingEntity eachBooking : bookings) {
            eachBooking.setUser(null);
        }
        return bookings;
    }
}
