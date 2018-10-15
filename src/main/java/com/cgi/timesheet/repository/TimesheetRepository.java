package com.cgi.timesheet.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgi.timesheet.domain.Employee;
import com.cgi.timesheet.domain.Timesheet;
import com.cgi.timesheet.domain.TimesheetStatus;

@Repository
public interface TimesheetRepository extends AbstractEntityRepository<Timesheet, Integer>{

	public List<Timesheet> findAllByEmployee(Employee employee);
	public List<Timesheet> findAllByEmployeeManagerAndTimesheetStatus(Employee employee, TimesheetStatus timesheetStatus);
	public Integer countAllByEmployeeAndTimesheetStatus(Employee employee, TimesheetStatus findByName);
	public Integer countAllByEmployeeManagerAndTimesheetStatus(Employee manager, TimesheetStatus findByName);
}
