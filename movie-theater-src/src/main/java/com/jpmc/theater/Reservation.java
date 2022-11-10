package com.jpmc.theater;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    /**
     * @param customer a customer
     * @param showing a showing
     * @param audienceCount the count number of audience
     */
    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    /**
     * Calculate and get the total fee of reservation
     * @return the amount of reservation
     */
    public double getTotalFee() {
    	BigDecimal multiply = showing.getMovieFee().multiply(BigDecimal.valueOf(audienceCount));
        return multiply.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}