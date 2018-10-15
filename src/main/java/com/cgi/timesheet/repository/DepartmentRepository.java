package com.cgi.timesheet.repository;

import org.springframework.stereotype.Repository;

import com.cgi.timesheet.domain.Department;

@Repository
public interface DepartmentRepository extends AbstractEntityWithNameRepository<Department, Integer>{

}
