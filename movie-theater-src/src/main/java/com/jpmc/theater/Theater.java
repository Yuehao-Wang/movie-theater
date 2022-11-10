package com.jpmc.theater;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.jpmc.theater.type.MovieCodeType;

public class Theater {

    LocalDateProvider provider;
    private List<Showing> schedule;

	public Theater(LocalDateProvider provider) {
        this.provider = provider;

		Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), BigDecimal.valueOf(12.5), MovieCodeType.SPECIAL);
		Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), BigDecimal.valueOf(11), MovieCodeType.NORMAL);
		Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), BigDecimal.valueOf(9), MovieCodeType.NORMAL);
		
        schedule = List.of(
            new Showing(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
            new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
            new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
            new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
            new Showing(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
            new Showing(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
            new Showing(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
            new Showing(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
            new Showing(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0)))
        );
    }

	/**
	 * customer can reserve showings 
	 * @param customer a customer
	 * @param sequence a sequence of showings: e.g. 1, 2, 3
	 * @param howManyTickets the number of tickets
	 * @return
	 */
    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        Showing showing;
        try {
            showing = schedule.get(sequence - 1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
        }
        return new Reservation(customer, showing, howManyTickets);
    }

    /**
     * Print Schedule with JSON formatter string.
     * @return a JSON string
     */
    public String printSchedule() {
    	System.out.println(provider.currentDate());
    	
    	TheaterUtils.printScheduleWithSimpleText(this.schedule);
    	
        String jsonSchedule = TheaterUtils.printScheduleWithJSON(this.schedule);
        
        return jsonSchedule;
    }
    

    public static void main(String[] args) {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }
}
