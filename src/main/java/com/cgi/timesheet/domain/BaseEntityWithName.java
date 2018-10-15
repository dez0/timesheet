package com.cgi.timesheet.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntityWithName<ID extends Serializable> extends BaseEntity<ID> {

	@Column
	protected String name;

	// Getter - Setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
