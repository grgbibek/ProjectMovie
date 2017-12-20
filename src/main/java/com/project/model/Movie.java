package com.project.model;

import javax.persistence.*;

/**
 * Created by grgbibek22 on 12/19/2017.
 */
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String movieName;
    private String directors;
    private String movieType;
    private String writer;
    private String stars;

    private long movieTimeDuration;
    private String showTime;

    private double ticketPrice;


    public int getMovieId() {
        return Id;
    }

    public void setMovieId(int Id) {
        this.Id = Id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public long getMovieTimeDuration() {
        return movieTimeDuration;
    }

    public void setMovieTimeDuration(long movieTimeDuration) {
        this.movieTimeDuration = movieTimeDuration;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
