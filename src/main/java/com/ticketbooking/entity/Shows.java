package com.ticketbooking.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name="shows")
public class Shows {
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
    private Movies movie;

    public Shows(Date date, String startTime, String endTime, Movies movie, String cinemaHall){
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

    public Movies getMovie() {
        return movie;
    }

    public String getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(String cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public Shows(){

    }

}
