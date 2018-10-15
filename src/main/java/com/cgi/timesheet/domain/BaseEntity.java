package com.cgi.timesheet.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private ID id;

	// Getter - Setter

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
}
