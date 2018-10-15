package com.cgi.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgi.timesheet.domain.Project;
import com.cgi.timesheet.service.ClientService;
import com.cgi.timesheet.service.EmployeeService;
import com.cgi.timesheet.service.ProjectService;
import com.cgi.timesheet.service.RoleService;
import com.cgi.timesheet.util.RoleEnum;

@Controller
@RequestMapping("/projects")
public class ProjectController extends AbstractBaseEntityController<ProjectService, Project, Integer> {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("project", new Project());
		model.addAttribute("allProjects", projectService.findAll());
		model.addAttribute("allClients", clientService.findAll());
		model.addAttribute("allEmployees", employeeService.findAll());
		model.addAttribute("allProjectManagers", roleService.findByName(RoleEnum.PROJECT_MANAGER.getNom()).getEmployees());
		return "project_list";
	}
}
