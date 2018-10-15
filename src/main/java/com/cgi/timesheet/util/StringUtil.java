package com.cgi.timesheet.util;

public class StringUtil {

	public static String capitalize(String string) {
		return Character.toUpperCase(string.charAt(0)) + string.substring(1);
	}
}
