package com.jpmc.theater.discount;

import java.math.BigDecimal;

import com.jpmc.theater.Showing;
import com.jpmc.theater.type.MovieCodeType;

/**
 * 20% discount for the special movie
 * @author amorn
 *
 */
public class SpecialDiscount implements DiscountStrategy {
	
	private static final BigDecimal RATE = BigDecimal.valueOf(0.2);

	@Override
	public BigDecimal calDiscount(Showing show) {
		// 20% discount for the special movie
		BigDecimal specialDiscount = BigDecimal.ZERO;
		
        if (MovieCodeType.SPECIAL == show.getMovie().getSpecialCode()) {
            specialDiscount = show.getMovie().getTicketPrice().multiply(RATE);  // 20% discount for special movie
        }
        return specialDiscount;
	}

}
