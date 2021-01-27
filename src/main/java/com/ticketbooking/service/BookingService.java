package com.ticketbooking.service;


import com.ticketbooking.entity.*;
import com.ticketbooking.model.Booking;
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

    public List<Shows> getAllShows(){
        List<Shows> allShows = showRepository.findAll();
        return allShows;
    }

    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Shows> getShowsForMovie(int movie){
        return showRepository.findByMovieMovieId(movie);
    }

    public void bookShow(Booking booking){
        Bookings bookings = new Bookings(new Date(), booking.getNoOfSeats(),userRepository.findByUsername(booking.getUserName()).get(), showRepository.findById(booking.getShowId()).get());
        Payments payments = new Payments(booking.getPayment().getAmount(), new Date(), bookings);
        transact(bookings, payments);
    }

    @Transactional
    public void transact(Bookings bookings, Payments payments){
        bookingRepository.save(bookings);
        paymentRepository.save(payments);
    }

    public List<Bookings> getUserBookings(String userName){
        User user = userRepository.findByUsername(userName).get();
        List<Bookings> bookings = bookingRepository.findByUserId(user.getId());
        for (Bookings eachBooking : bookings) {
            eachBooking.setUser(null);
        }
        return bookings;
    }
}
