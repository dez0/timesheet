package com.cgi.timesheet.repository;

import org.springframework.stereotype.Repository;

import com.cgi.timesheet.domain.TimesheetStatus;

@Repository
public interface TimesheetStatusRepository extends AbstractEntityWithNameRepository<TimesheetStatus, Integer>{

}
