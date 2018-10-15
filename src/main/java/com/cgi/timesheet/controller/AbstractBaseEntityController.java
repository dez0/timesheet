package com.cgi.timesheet.controller;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgi.timesheet.domain.BaseEntity;
import com.cgi.timesheet.service.AbstractBaseEntityService;

public abstract class AbstractBaseEntityController<S extends AbstractBaseEntityService<E, ID>, E extends BaseEntity<ID>, ID extends Serializable> {

	@Autowired
	protected S genericService;

	// API

	@ResponseBody
    @GetMapping("/find/{id}")
    public E find(@PathVariable("id") ID id) {
    	Optional<E> entity = genericService.findById(id);
        return entity.get();
    }

	@ResponseBody
    @PostMapping("/save")
    public E save(@ModelAttribute E entity) {
    	return genericService.save(entity);
    }

	@ResponseBody
    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") ID id) {
    	genericService.delete(id);
        return true;
    }
}
