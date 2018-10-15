package com.cgi.timesheet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cgi.timesheet.domain.Project;
import com.cgi.timesheet.service.ProjectService;

@Component
public class ProjectConverter implements Converter<String, Project> {

	@Autowired
	private ProjectService projectService;

	@Override
	public Project convert(String id) {
		return projectService.findById(Integer.valueOf(id)).get();
	}
}
