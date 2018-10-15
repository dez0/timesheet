package com.cgi.timesheet.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.timesheet.domain.Employee;
import com.cgi.timesheet.domain.Project;
import com.cgi.timesheet.domain.Timesheet;
import com.cgi.timesheet.domain.TimesheetRow;
import com.cgi.timesheet.repository.TimesheetRepository;
import com.cgi.timesheet.util.DateUtil;
import com.cgi.timesheet.util.TimesheetStatusEnum;

@Service
public class TimesheetService extends AbstractBaseEntityService<Timesheet, Integer> {

	@Autowired
	private TimesheetRepository timesheetRepository;

	@Autowired
	private TimesheetStatusService timesheetStatusService;
	
	public List<Timesheet> findAllByEmployee(Employee employee) {
		return timesheetRepository.findAllByEmployee(employee);
	}
	
	public List<Timesheet> findAllPendingByManager(Employee manager) {
		return timesheetRepository.findAllByEmployeeManagerAndTimesheetStatus(manager, timesheetStatusService.findByName(TimesheetStatusEnum.PENDING.getNom()));
	}
	
	public Integer countAllRefusedByEmployee(Employee employee) {
		return timesheetRepository.countAllByEmployeeAndTimesheetStatus(employee, timesheetStatusService.findByName(TimesheetStatusEnum.REFUSED.getNom()));
	}
	
	public Integer countAllPendingByManager(Employee manager) {
		return timesheetRepository.countAllByEmployeeManagerAndTimesheetStatus(manager, timesheetStatusService.findByName(TimesheetStatusEnum.PENDING.getNom()));
	}
	
	public Timesheet createDraftTimesheet(Employee employee, Project project, Date startDate) {
		Timesheet timesheet = new Timesheet();
		
		timesheet.setStartDate(startDate);
		timesheet.setEndDate(DateUtil.moveDays(startDate, 6));
		timesheet.setTimesheetStatus(timesheetStatusService.findByName(TimesheetStatusEnum.DRAFT.getNom()));
		timesheet.setEmployee(employee);
		timesheet.setTotal(BigDecimal.ZERO);
		
		for(int i = 0; i < 7; i++) {
			TimesheetRow row = new TimesheetRow();
			row.setDate(DateUtil.moveDays(startDate, i));
			row.setProject(project);
			row.setTimesheet(timesheet);
			timesheet.getTimesheetRows().add(row);
		}
		
		return timesheet;
	}
	
	public void updateTimesheet(Timesheet timesheet, String statusName, boolean updateTotal) {
		timesheet.setTimesheetStatus(timesheetStatusService.findByName(statusName));
		if(updateTotal) {
			updateTimesheetTotal(timesheet);
		}
		save(timesheet);
	}
	
	private void updateTimesheetTotal(Timesheet timesheet) {
		BigDecimal total = BigDecimal.ZERO;
		
		for(TimesheetRow row : timesheet.getTimesheetRows()) {
			if(row.getValue() != null) {
				total = total.add(row.getValue());
			}
		}
		
		timesheet.setTotal(total);
	}
}
