package com.ticketbooking.service;


import com.ticketbooking.entity.*;
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
        BookingEntity bookingEntity = new BookingEntity(new Date(), booking.getNoOfSeats(),userRepository.findByUsername(booking.getUserName()).get(), showRepository.findById(booking.getShowId()).get());
        PaymentEntity paymentEntity = new PaymentEntity(booking.getPayment().getAmount(), new Date(),bookingEntity);
        transact(bookingEntity, paymentEntity);
    }

    @Transactional
    public void transact(BookingEntity bookingEntity, PaymentEntity paymentEntity){
        bookingRepository.save(bookingEntity);
        paymentRepository.save(paymentEntity);
    }

    public List<BookingEntity> getUserBookings(String userName){
        User user = userRepository.findByUsername(userName).get();
        List<BookingEntity> bookings = bookingRepository.findByUserId(user.getId());
        for (BookingEntity eachBooking : bookings) {
            eachBooking.setUser(null);
        }
        return bookings;
    }
}
