package com.jpmc.theater;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jpmc.theater.discount.DiscountHelper;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    /**
     * @param movie a Movie
     * @param sequenceOfTheDay the day of sequence
     * @param showStartTime a show start time
     */
    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    /**
     * Calculate the movie fee: movie fee = original movie price - discount <br>
     * 
     * 1) calculate the discount <br>
     * 2) check if the fee is less than 0.00. If so, return 0.00 <br>
     * @return the minimum fee is 0.00
     */
	public BigDecimal getMovieFee() {
		// 1) calculate the discount
		BigDecimal maxDiscount = DiscountHelper.getMaxDiscount(this);
		
		// 2) check if the fee is less than 0.00. If so, return 0.00
		BigDecimal subtract = this.movie.getTicketPrice().subtract(maxDiscount);
		
		// price is $1. discount is $3. subtract is $-2 that is incorrect, then return $0
		if (subtract.compareTo(BigDecimal.ZERO) < 0) {
			return BigDecimal.ZERO;
		}
		return subtract;
	}

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }
    
}
