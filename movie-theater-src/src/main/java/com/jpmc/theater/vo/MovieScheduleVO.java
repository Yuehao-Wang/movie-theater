package com.jpmc.theater.vo;

/**
 * VO is used for building JSON string.
 * @author amorn
 *
 */
public class MovieScheduleVO {
	
	private int sequenceOfTheDay; // 1,2,3
	
	private String startTime; // yyyy:MM:dd hh:mm:ss
	
	private String endTime; // startTime + runningTime
	
	private String title; // The Batman
	
	private String runningTime; // 1 hour 35 minutes
	
	private double movieFee; //

	public int getSequenceOfTheDay() {
		return sequenceOfTheDay;
	}

	public void setSequenceOfTheDay(int sequenceOfTheDay) {
		this.sequenceOfTheDay = sequenceOfTheDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public double getMovieFee() {
		return movieFee;
	}

	public void setMovieFee(double movieFee) {
		this.movieFee = movieFee;
	}
	
	
}
