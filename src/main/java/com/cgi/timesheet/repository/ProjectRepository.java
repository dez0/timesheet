package com.cgi.timesheet.repository;

import org.springframework.stereotype.Repository;

import com.cgi.timesheet.domain.Project;

@Repository
public interface ProjectRepository extends AbstractEntityWithNameRepository<Project, Integer>{

}
