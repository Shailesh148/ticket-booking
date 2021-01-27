package com.ticketbooking.service;


import com.ticketbooking.entity.MovieEntity;
import com.ticketbooking.entity.ShowEntity;
import com.ticketbooking.model.Movie;
import com.ticketbooking.model.Show;
import com.ticketbooking.repository.MovieRepository;
import com.ticketbooking.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    MovieRepository movieRepository;


    @Autowired
    ShowRepository showRepository;

    public void addMovie(Movie movie){
        movieRepository.save(new MovieEntity(movie.getTitle(), movie.getDuration(), movie.getGenre()));
    }


    public void addShow(Show show){
        MovieEntity movieEntity = movieRepository.findByTitle(show.getMovieName());
        showRepository.save(new ShowEntity(show.getDate(), show.getStartTime(), show.getEndTime(), movieEntity, show.getCinemaHall()));
    }
}
