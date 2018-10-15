package com.cgi.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgi.timesheet.domain.Department;
import com.cgi.timesheet.service.DepartmentService;

@RequestMapping("/departments")
@Controller
public class DepartmentController extends AbstractBaseEntityController<DepartmentService, Department, Integer> {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("department", new Department());
		model.addAttribute("allDepartments", departmentService.findAll());
		return "department_list";
	}
}
