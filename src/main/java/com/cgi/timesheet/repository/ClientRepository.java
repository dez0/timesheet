package com.cgi.timesheet.repository;

import org.springframework.stereotype.Repository;

import com.cgi.timesheet.domain.Client;

@Repository
public interface ClientRepository extends AbstractEntityWithNameRepository<Client, Integer>{

}
