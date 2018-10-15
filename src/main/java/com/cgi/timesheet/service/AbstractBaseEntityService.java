package com.cgi.timesheet.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cgi.timesheet.domain.BaseEntity;

@Service
public abstract class AbstractBaseEntityService<E extends BaseEntity<ID>, ID extends Serializable> {

	@Autowired
	protected CrudRepository<E, ID> genericRepository;
	
	public Iterable<E> findAll() {
		return genericRepository.findAll();
	}
	
	public Optional<E> findById(ID id) {
		return genericRepository.findById(id);
	}
	
	public E save(E entity) {
		return genericRepository.save(entity);
	}
	
	public void delete(ID id) {
		genericRepository.deleteById(id);
	}
}
