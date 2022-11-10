package com.jpmc.theater;

import java.util.List;

import com.jpmc.theater.vo.MovieScheduleVO;

import net.sf.json.JSONArray;

public class TheaterUtils {

	/**
	 * print the movie schedule with simple text
	 * @param schedule list of Showing
	 */
	public static void printScheduleWithSimpleText(List<Showing> schedule) {
    	
    	System.out.println("===================================================");
        
        schedule.forEach(s ->
        System.out.println(s.getSequenceOfTheDay() + ": " + s.getStartTime() + " " + s.getMovie().getTitle() + " " + DateUtils.humanReadableFormat(s.getMovie().getRunningTime()) + " $" + s.getMovieFee())
		);
        System.out.println("===================================================");
    }
    
	/**
	 * print the movie schedule with Json format
	 * @param schedule list of Showing
	 * @return Json String
	 */
	public static String printScheduleWithJSON(List<Showing> schedule) {
    	System.out.println("===================================================");
    	
    	List<MovieScheduleVO> scheduleVOs = ScheduleUtils.convertScheduleVO(schedule);
        
        JSONArray jsonObj = JSONArray.fromObject(scheduleVOs);
        System.out.println(jsonObj.toString());
        System.out.println("===================================================");
        
        return jsonObj.toString();
    }
    
}
