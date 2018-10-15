package com.cgi.timesheet.repository;

import org.springframework.stereotype.Repository;

import com.cgi.timesheet.domain.Employee;

@Repository
public interface EmployeeRepository extends AbstractEntityRepository<Employee, Integer>{

	public Employee findByEmail(String email);
}
