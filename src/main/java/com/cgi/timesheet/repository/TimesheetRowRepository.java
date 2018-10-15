package com.cgi.timesheet.repository;

import org.springframework.stereotype.Repository;

import com.cgi.timesheet.domain.TimesheetRow;

@Repository
public interface TimesheetRowRepository extends AbstractEntityRepository<TimesheetRow, Integer>{

}
