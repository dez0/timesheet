package com.cgi.timesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.timesheet.domain.Project;
import com.cgi.timesheet.repository.ProjectRepository;

@Service
public class ProjectService extends AbstractBaseEntityWithNameService<Project, Integer> {

	@Autowired
	private ProjectRepository projectRepository;
	
	public void delete(Integer id) {
		projectRepository.findById(id).get().getAssignedEmployees().clear();
		super.delete(id);
	}
}
