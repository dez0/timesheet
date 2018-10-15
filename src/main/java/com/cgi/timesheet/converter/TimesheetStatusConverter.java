package com.cgi.timesheet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cgi.timesheet.domain.TimesheetStatus;
import com.cgi.timesheet.service.TimesheetStatusService;

@Component
public class TimesheetStatusConverter implements Converter<String, TimesheetStatus> {

	@Autowired
	private TimesheetStatusService timesheetStatusService;

	@Override
	public TimesheetStatus convert(String id) {
		return timesheetStatusService.findById(Integer.valueOf(id)).get();
	}
}
