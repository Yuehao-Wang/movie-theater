package com.jpmc.theater.discount;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jpmc.theater.Showing;

/**
 * Any movies showing on 7th, you'll get 1$ discount
 * @author amorn
 *
 */
public class MonthOfDateDiscount implements DiscountStrategy {

	@Override
	public BigDecimal calDiscount(Showing show) {
		BigDecimal discount = BigDecimal.ZERO;
        
		
		LocalDateTime startTime = show.getStartTime();
		
		int dayOfMonth = startTime.getDayOfMonth();
		if (dayOfMonth == 7) {
			discount = BigDecimal.ONE;
		}
        
        return discount;
	}

}
