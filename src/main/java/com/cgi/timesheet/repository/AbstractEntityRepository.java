package com.cgi.timesheet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.cgi.timesheet.domain.BaseEntity;

@NoRepositoryBean
public interface AbstractEntityRepository<E extends BaseEntity<ID>, ID extends Serializable> extends CrudRepository<E, ID>{

}
