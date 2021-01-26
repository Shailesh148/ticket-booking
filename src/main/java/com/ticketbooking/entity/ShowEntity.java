package com.ticketbooking.entity;


import com.ticketbooking.model.Show;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ShowEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="showId")
    private int showId;

    @Column(name="date")
    private String date;

    @Column(name="startTime")
    private String startTime;

    @Column(name="endTime")
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private MovieEntity movie;

    public ShowEntity(String date, String startTime, String endTime, MovieEntity movie){
        this.date= date;
        this.startTime= startTime;
        this.endTime = endTime;
        this.movie = movie;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public ShowEntity(){

    }

}
