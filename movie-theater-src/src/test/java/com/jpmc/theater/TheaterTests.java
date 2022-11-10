package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import com.jpmc.theater.vo.MovieScheduleVO;

import net.sf.json.JSONArray;

public class TheaterTests {
	
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
        
        // one ticket is 9.38, because the showing starts between 11AM ~ 4pm, you'll get 25% discount
        assertEquals(37.52, reservation.getTotalFee());
    }

    @Test
    void printMovieScheduleWithSimpleText() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printScheduleWithSimpleText();
    }
    
    
    @Test
    void printMovieScheduleWithJSON() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        String jsonSchedule = theater.printScheduleWithJSON();
        
        JSONArray jsonArr = JSONArray.fromObject(jsonSchedule);
        Collection<MovieScheduleVO> collection = JSONArray.toCollection(jsonArr, MovieScheduleVO.class);
        
        assertEquals(9, collection.size());
        
    }
}
