package com.cgi.timesheet.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getPreviousSundayFromDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_WEEK, -(calendar.get(Calendar.DAY_OF_WEEK)-1));
		return calendar.getTime();
	}
	
	public static Date moveDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
