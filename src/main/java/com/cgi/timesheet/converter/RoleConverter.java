package com.cgi.timesheet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cgi.timesheet.domain.Role;
import com.cgi.timesheet.service.RoleService;

@Component
public class RoleConverter implements Converter<String, Role> {

	@Autowired
	private RoleService roleService;

	@Override
	public Role convert(String id) {
		return roleService.findById(Integer.valueOf(id)).get();
	}
}
