package com.ticketbooking.service;


import com.ticketbooking.entity.MovieEntity;
import com.ticketbooking.entity.ShowEntity;
import com.ticketbooking.repository.MovieRepository;
import com.ticketbooking.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class BookingService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    public List<ShowEntity> getAllShows(){
        List<ShowEntity> allShows = showRepository.findAll();
        return allShows;
    }

    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }
}
