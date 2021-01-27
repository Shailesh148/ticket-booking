package com.ticketbooking.entity;


import com.ticketbooking.model.Show;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name="shows")
public class ShowEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="showId")
    private int showId;

    @Column(name="date")
    private Date date;

    @Column(name="startTime")
    private String startTime;

    @Column(name="endTime")
    private String endTime;

    @Column(name="cinemaHall")
    private String cinemaHall;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private MovieEntity movie;

    public ShowEntity(Date date, String startTime, String endTime, MovieEntity movie,String cinemaHall){
        this.date= date;
        this.startTime= startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.cinemaHall = cinemaHall;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public String getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(String cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public ShowEntity(){

    }

}
