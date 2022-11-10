package com.jpmc.theater;

import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jpmc.theater.vo.MovieScheduleVO;

public class ScheduleUtils {
	
	/**
	 * Convert a list of Showing to a list of MovieScheduleVO
	 * @param shows list of Showing
	 * @return list of MovieScheduleVO
	 */
	public static List<MovieScheduleVO> convertScheduleVO(List<Showing> shows) {
		List<MovieScheduleVO> voList = new ArrayList<MovieScheduleVO>();
		if (shows == null) {
			return voList;
		}
		
		for (Showing s : shows) {
			MovieScheduleVO vo = new MovieScheduleVO();
			vo.setSequenceOfTheDay(s.getSequenceOfTheDay());
			vo.setStartTime(DateUtils.getDateTimeStr(s.getStartTime(), DateUtils.SIMPLY_FORMATTER));
			
			LocalDateTime startTime = s.getStartTime();
			Duration runningTime = s.getMovie().getRunningTime();
			LocalDateTime endTime = startTime.plus(runningTime);
			vo.setEndTime(DateUtils.getDateTimeStr(endTime, DateUtils.SIMPLY_FORMATTER));
			
			vo.setTitle(s.getMovie().getTitle());
			vo.setRunningTime(DateUtils.humanReadableFormat(s.getMovie().getRunningTime()));
			vo.setMovieFee(s.getMovieFee().doubleValue());
			
			voList.add(vo);
		}
		
		return voList;
	}
	
	

}
