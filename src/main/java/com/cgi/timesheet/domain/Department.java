package com.cgi.timesheet.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department extends BaseEntityWithName<Integer> {

	@JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    
	// Getter - Setter

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
