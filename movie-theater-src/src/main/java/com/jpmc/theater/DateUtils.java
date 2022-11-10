package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class DateUtils {
	
	public static final String SIMPLY_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	public static final String SHORT_DATE_FORMATTER = "yyyy-MM-dd";
	public static final String SHORT_TIME_FORMATTER = "HH:mm:ss";
	
	/**
	 * Convert a LocalDateTime to String by formatter
	 * @param dateTime a LocalDateTime
	 * @param pattern "yyyy-MM-dd HH:mm:ss"
	 * @return string 2022-11-09 10:20:30
	 */
	public static String getDateTimeStr(LocalDateTime dateTime, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
				
		return dateTime.format(formatter);
	}
	
	/**
	 * Convert a Duration to a readable string
	 * @param duration a Duration
	 * @return 1 hour 15 minutes
	 */
	public static String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("%s hour%s %s minute%s", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }
	
	
	// (s) postfix should be added to handle plural correctly
    private static String handlePlural(long value) {
        if (value == 1) {
            return "";
        }
        else {
            return "s";
        }
    }
}
