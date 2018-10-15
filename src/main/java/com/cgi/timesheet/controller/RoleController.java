package com.cgi.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgi.timesheet.domain.Role;
import com.cgi.timesheet.service.RoleService;

@Controller	
@RequestMapping("/roles")
public class RoleController extends AbstractBaseEntityController<RoleService, Role, Integer> {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("role", new Role());
		model.addAttribute("allRoles", roleService.findAll());
		return "role_list";
	}
}
