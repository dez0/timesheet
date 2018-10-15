package com.cgi.timesheet.repository;

import org.springframework.stereotype.Repository;

import com.cgi.timesheet.domain.Role;

@Repository
public interface RoleRepository extends AbstractEntityWithNameRepository<Role, Integer>{

}
