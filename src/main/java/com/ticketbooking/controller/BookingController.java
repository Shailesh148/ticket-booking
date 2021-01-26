package com.ticketbooking.controller;


import com.ticketbooking.entity.MovieEntity;
import com.ticketbooking.entity.ShowEntity;
import com.ticketbooking.model.Movie;
import com.ticketbooking.service.BookingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
@RequestMapping("/booking")
public class BookingController {


    @Autowired
    BookingService bookingService;

    @GetMapping(value="all_shows", produces="application/json")
    public ResponseEntity getAllShows(){
        List<ShowEntity> allShows = bookingService.getAllShows();
        return new ResponseEntity<>(allShows, HttpStatus.OK);
    }

    @GetMapping(value="all_movies",produces="application/json")
    public ResponseEntity getAllMovies(){
        return new ResponseEntity<>(bookingService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping(value="show", produces = "application/json")
    public ResponseEntity getMoviesForShow(@RequestParam int movie){
        return new ResponseEntity<>(bookingService.getShowsForMovie(movie), HttpStatus.OK);
    }
}
