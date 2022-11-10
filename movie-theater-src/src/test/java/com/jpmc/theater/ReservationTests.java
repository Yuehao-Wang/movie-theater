package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.jpmc.theater.type.MovieCodeType;

public class ReservationTests {

	/**
	 * reserve 3 tickets for 20% discount for the special movie
	 * expect 28.5
	 */
    @Test
    void reserveSpecialMovieWith20PercentDiscountTotalFee() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(12.5), MovieCodeType.SPECIAL),
                1,
                LocalDateTime.now()
        );
        assertTrue(new Reservation(customer, showing, 3).getTotalFee() == 28.5);
    }
    
    /**
     * reserve 3 tickets for $3 discount for the movie showing 1st of the day
     * expect 21.00
     */
    @Test
    void reserveNormalMovie1stDayDiscountWith3Dollar() {
    	var customer = new Customer("John Doe", "unused-id");
    	Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        
        assertEquals(21.00, new Reservation(customer, showing, 3).getTotalFee());
    }
    
    /**
     * reserve 3 tickets for $2 discount for the movie showing 2nd of the day
     * expect 24.00
     */
    @Test
    void reserveNormalMovie2ndDayDiscountWith2Dollar() {
    	var customer = new Customer("John Doe", "unused-id");
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        assertEquals(24.00, new Reservation(customer, showing, 3).getTotalFee());
    }
    
    /**
     * reserve 3 tickets for any movies showing starting between [11AM ~ 4pm), you'll get 25% discount
     * expect 22.50
     */
    @Test
    void reserveNormalMovieStart11AMWith25PercentDiscount() {
    	var customer = new Customer("John Doe", "unused-id");
    	Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));

        assertEquals(22.50, new Reservation(customer, showing, 3).getTotalFee());
    }
}
