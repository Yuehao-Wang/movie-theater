package com.jpmc.theater.discount;

import java.math.BigDecimal;

import com.jpmc.theater.Showing;

/**
 * $3 discount for the movie showing 1st of the day
 * $2 discount for the movie showing 2nd of the day
 * @author amorn
 *
 */
public class SequenceDiscount implements DiscountStrategy {

	@Override
	public BigDecimal calDiscount(Showing show) {
		BigDecimal sequenceDiscount = BigDecimal.ZERO;
        switch (show.getSequenceOfTheDay()) {
		case 1:
			sequenceDiscount = BigDecimal.valueOf(3); // $3 discount for 1st show
			break;
		case 2:
			sequenceDiscount = BigDecimal.valueOf(2); // $2 discount for 2nd show
			break;
		default:
			sequenceDiscount = BigDecimal.ZERO;
		}
        
        return sequenceDiscount;
        
	}

}
