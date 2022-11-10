package com.jpmc.theater;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Objects;

import com.jpmc.theater.type.MovieCodeType;

public class Movie {
    private String title;
    private String description;
    private Duration runningTime;
    private BigDecimal ticketPrice;
    private MovieCodeType specialCode;

    /**
     * @param title movie title
     * @param runningTime movie running time
     * @param ticketPrice price of movie
     * @param specialCode type of movie
     */
    public Movie(String title, Duration runningTime, BigDecimal ticketPrice, MovieCodeType specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }
    
    public MovieCodeType getSpecialCode() {
    	return this.specialCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movie.ticketPrice.compareTo(ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}