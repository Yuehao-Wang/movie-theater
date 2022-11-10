package com.jpmc.theater.discount;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jpmc.theater.Showing;

/**
 * Any movies showing starting between [11AM ~ 4pm), you'll get 25% discount
 * @author amorn
 *
 */
public class TimeDiscount implements DiscountStrategy {
	
	private static final BigDecimal RATE = BigDecimal.valueOf(0.25);

	@Override
	public BigDecimal calDiscount(Showing show) {
		BigDecimal discount = BigDecimal.ZERO;
        
		
		LocalDateTime startTime = show.getStartTime();
		
		int hour = startTime.getHour();
		if (hour >= 11 && hour < 16) {
			discount = show.getMovie().getTicketPrice().multiply(RATE);
		}
        
        return discount;
	}

}
