package com.cgi.timesheet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cgi.timesheet.domain.Employee;
import com.cgi.timesheet.service.EmployeeService;

@Component
public class EmployeeConverter implements Converter<String, Employee> {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public Employee convert(String id) {
		return employeeService.findById(Integer.valueOf(id)).get();
	}
}
