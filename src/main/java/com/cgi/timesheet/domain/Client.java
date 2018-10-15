package com.cgi.timesheet.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client extends BaseEntityWithName<Integer> {

	@JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Project> projects;
    
	// Getter - Setter

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
