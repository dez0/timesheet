package com.cgi.timesheet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cgi.timesheet.domain.Department;
import com.cgi.timesheet.service.DepartmentService;


@Component
public class DepartmentConverter implements Converter<String, Department> {

	@Autowired
	private DepartmentService departmentService;

	@Override
	public Department convert(String id) {
		return departmentService.findById(Integer.valueOf(id)).get();
	}
}
