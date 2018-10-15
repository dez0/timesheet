package com.cgi.timesheet.domain;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cgi.timesheet.util.StringUtil;

@Entity
public class TimesheetRow extends BaseEntity<Integer> {

	@Column
	protected Date date;

	@Column
	protected BigDecimal value;
	
    @ManyToOne
    @JoinColumn(name = "timesheet_id")
    private Timesheet timesheet;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    
    // Utility
    
    public String getFormattedDate() {
    	DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
    	return outputFormatter.format(date); 
    }
    
    public String getDayOfWeek() {
    	DateFormat outputFormatter = new SimpleDateFormat("EEEE", Locale.CANADA_FRENCH);
    	return StringUtil.capitalize(outputFormatter.format(date)); 
    }
    
	// Getter - Setter

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Timesheet getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
