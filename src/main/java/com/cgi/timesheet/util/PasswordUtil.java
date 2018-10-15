package com.cgi.timesheet.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	public static String encode(String password) {
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    	return encoder.encode(password);
	}
}
