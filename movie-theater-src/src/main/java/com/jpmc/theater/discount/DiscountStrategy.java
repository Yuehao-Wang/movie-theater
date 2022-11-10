package com.jpmc.theater.discount;

import java.math.BigDecimal;

import com.jpmc.theater.Showing;

public interface DiscountStrategy {
	
	/**
	 * Calculate the discount for Showing
	 * @param show a Showing
	 * @return the amount of discount
	 */
	public BigDecimal calDiscount(Showing show);
}
