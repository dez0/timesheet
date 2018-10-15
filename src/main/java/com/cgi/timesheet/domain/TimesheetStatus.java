package com.cgi.timesheet.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TimesheetStatus extends BaseEntityWithName<Integer> {

	@JsonIgnore
    @OneToMany(mappedBy = "timesheetStatus")
    private List<Timesheet> timesheets;
    
	// Getter - Setter

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
}
