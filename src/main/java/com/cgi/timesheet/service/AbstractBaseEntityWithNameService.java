package com.cgi.timesheet.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.timesheet.domain.BaseEntityWithName;
import com.cgi.timesheet.repository.AbstractEntityWithNameRepository;

@Service
public abstract class AbstractBaseEntityWithNameService<E extends BaseEntityWithName<ID>, ID extends Serializable> extends AbstractBaseEntityService<E, ID> {

	@Autowired
	protected AbstractEntityWithNameRepository<E, ID> genericRepository;
	
	public E findByName(String name) {
		return genericRepository.findByName(name);
	}
}
