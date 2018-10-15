package com.cgi.timesheet.domain;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Timesheet extends BaseEntity<Integer> {

	@Column
	protected BigDecimal total;

	@Column
	protected String notes;

	@Column
	protected Date startDate;

	@Column
	protected Date endDate;
	
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "timesheet_status_id")
    private TimesheetStatus timesheetStatus;

    @OneToMany(mappedBy = "timesheet", cascade = CascadeType.ALL)
    private List<TimesheetRow> timesheetRows;
    
    // Utility
    
    public String getFormattedStartDate() {
    	DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
    	return outputFormatter.format(startDate); 
    }
    
    public String getFormattedEndDate() {
    	DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
    	return outputFormatter.format(endDate); 
    }
    
    public String getFormattedDateRange() {
    	return "Du " + getFormattedStartDate() + " au " + getFormattedEndDate();
    }
    
    public Map<Project, List<TimesheetRow>> getProjects() {
    	Map<Project, List<TimesheetRow>> projects = new HashMap<Project, List<TimesheetRow>>();
    	
    	for(TimesheetRow row : timesheetRows) {
    		if(projects.get(row.getProject()) == null) {
    			projects.put(row.getProject(), new ArrayList<TimesheetRow>());
    			projects.get(row.getProject()).add(row);
    		} else {
    			projects.get(row.getProject()).add(row);
    		}
    	}
    	
    	return projects;
    }
    
	// Getter - Setter

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public TimesheetStatus getTimesheetStatus() {
		return timesheetStatus;
	}

	public void setTimesheetStatus(TimesheetStatus timesheetStatus) {
		this.timesheetStatus = timesheetStatus;
	}

	public List<TimesheetRow> getTimesheetRows() {
		if(timesheetRows == null) {
			timesheetRows = new ArrayList<TimesheetRow>();
		}
		return timesheetRows;
	}

	public void setTimesheetRows(List<TimesheetRow> timesheetRows) {
		this.timesheetRows = timesheetRows;
	}
}
