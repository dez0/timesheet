package com.cgi.timesheet.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role extends BaseEntityWithName<Integer> {

	@JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<Employee> employees;
    
	// Getter - Setter

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
