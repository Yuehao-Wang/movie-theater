package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import com.jpmc.theater.type.MovieCodeType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
	/**
	 * 20% discount for the special movie
	 * expect 10.00
	 */
    @Test
    void specialMovieWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(12.5), MovieCodeType.SPECIAL);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        assertEquals(10.00, showing.getMovieFee().doubleValue());
    }
    
    
    /**
     * $3 discount for the movie showing 1st of the day
     * expect 7.00
     */
    @Test
    void normalMovie1stDayDiscountWith3Dollar() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        assertEquals(7.00, showing.getMovieFee().doubleValue());
    }
    
    /**
     * $2 discount for the movie showing 2nd of the day
     * expect 8.00
     */
    @Test
    void normalMovie2ndDayDiscountWith2Dollar() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        assertEquals(8.00, showing.getMovieFee().doubleValue());
    }
    
    /**
     * $0 discount for the movie showing 3rd of the day
     * expect 10.00
     */
    @Test
    void normalMovie2ndDayDiscountWith0Dollar() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        assertEquals(10.00, showing.getMovieFee().doubleValue());
    }
    
    /**
     * Any movies showing starting between [11AM ~ 4pm), you'll get 25% discount
     * expect 7.50
     */
    @Test
    void normalMovieStart11AMWith25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));

        assertEquals(7.50, showing.getMovieFee().doubleValue());
    }
    
    /**
     * Any movies showing starting between [11AM ~ 4pm), you'll get 25% discount
     * expect 10.00
     */
    @Test
    void normalMovieStart16PMWithout25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 0)));

        assertEquals(10.00, showing.getMovieFee().doubleValue());
    }
    
    /**
     * Any movies showing starting between [11AM ~ 4pm), you'll get 25% discount
     * expect 9.38
     */
    @Test
    void normalMovieStartBefore16PMWith25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(12.5), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 59)));

        assertEquals(9.38, showing.getMovieFee().doubleValue());
    }
    
    /**
     * Any movies showing on 7th, you'll get 1$ discount
     * expect 9.00
     */
    @Test
    void normalMovieShowOn7thWith1DollarDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.of(2022, 11, 7), LocalTime.of(16, 59)));
        
        assertEquals(9.00, showing.getMovieFee().doubleValue());
    }
    
    /**
     * Any movies showing on 8th, you'll get 0$ discount
     * expect 10.00
     */
    @Test
    void normalMovieShowOn8thWithNoDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10), MovieCodeType.NORMAL);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.of(2022, 11, 8), LocalTime.of(16, 59)));
        
        assertEquals(10.00, showing.getMovieFee().doubleValue());
    }
    
    /**
     * price : $10
	 * SPECIAL: 20% = $2
	 * 1st day showing : $3. The max discount
	 * 15:59: 25% = $2.5
	 * 7th of month: $1
	 * expect 7.00
	 */
    @Test
    void specialMovieWithMaxDiscount3DollarDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(10.00), MovieCodeType.SPECIAL);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.of(2022, 11, 7), LocalTime.of(15, 59)));

        assertEquals(7.00, showing.getMovieFee().doubleValue());
    }
    
    /**
     * price : $100
	 * SPECIAL: 20% = $20
	 * 1st day showing : $3. The max discount
	 * 15:59: 25% = $25
	 * 7th of month: $1
	 * 
	 * expect 75.00
	 */
    @Test
    void specialMovie100WithMaxDiscount25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(100.00), MovieCodeType.SPECIAL);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.of(2022, 11, 7), LocalTime.of(15, 59)));

        assertEquals(75.00, showing.getMovieFee().doubleValue());
    }
    
    /**
     * price : $1
	 * SPECIAL: 20% = $0.2
	 * 1st day showing : $3. The max discount
	 * 15:59: 25% = $0.25
	 * 7th of month: $1
	 * 
	 * expect  0.00
	 */
    @Test
    void specialMovieDiscountIsGreaterThanPrice() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(1.00), MovieCodeType.SPECIAL);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.of(2022, 11, 7), LocalTime.of(15, 59)));

        assertEquals(0.00, showing.getMovieFee().doubleValue());
    }
}
