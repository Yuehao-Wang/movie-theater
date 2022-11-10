package com.jpmc.theater.discount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jpmc.theater.Showing;

public class DiscountHelper {
	
	/**
	 * The discount amount applied only one if met multiple rules; biggest amount one
	 * @param show the instance of Showing
	 * @return the amount of the maximum discount.
	 */
	public static BigDecimal getMaxDiscount(Showing show) {
		
		BigDecimal res = BigDecimal.ZERO;
		
		List<BigDecimal> lst = new ArrayList<>();
		
		BigDecimal specialDiscount = new SpecialDiscount().calDiscount(show);
		lst.add(specialDiscount);
		
		BigDecimal sequenceDiscount = new SequenceDiscount().calDiscount(show);
		lst.add(sequenceDiscount);
		
		BigDecimal timeDiscount = new TimeDiscount().calDiscount(show);
		lst.add(timeDiscount);
		
		BigDecimal monthOfDateDiscount = new MonthOfDateDiscount().calDiscount(show);
		lst.add(monthOfDateDiscount);
		
		// sort
		Collections.sort(lst);
		
		// get the maximum discount
		res = lst.get(lst.size() - 1);
		
		return res;
	}
}
