package com.cgi.timesheet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.cgi.timesheet.domain.BaseEntityWithName;

@NoRepositoryBean
public interface AbstractEntityWithNameRepository<E extends BaseEntityWithName<ID>, ID extends Serializable> extends CrudRepository<E, ID>{

	public E findByName(String name);
}
