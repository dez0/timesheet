package com.cgi.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgi.timesheet.domain.Employee;
import com.cgi.timesheet.service.DepartmentService;
import com.cgi.timesheet.service.EmployeeService;
import com.cgi.timesheet.service.RoleService;
import com.cgi.timesheet.service.TimesheetService;
import com.cgi.timesheet.util.RoleEnum;

@RequestMapping("/employees")
@Controller
public class EmployeeController extends AbstractBaseEntityController<EmployeeService, Employee, Integer> {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private TimesheetService timesheetService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("allEmployees", employeeService.findAll());
		model.addAttribute("allManagers", roleService.findByName(RoleEnum.MANAGER.getNom()).getEmployees());
		model.addAttribute("allRoles", roleService.findAll());
		model.addAttribute("allDepartments", departmentService.findAll());
		return "employee_list";
	}

	@GetMapping(value = "/countTimesheetNotification")
	@ResponseBody
	public Integer countTimesheetNotification(Model model, @AuthenticationPrincipal User user) {
		Employee currentEmployee = employeeService.findByEmail(user.getUsername());
		Integer refusedTimesheet = timesheetService.countAllRefusedByEmployee(currentEmployee);
		Integer pendingTimesheet = timesheetService.countAllPendingByManager(currentEmployee);
		return pendingTimesheet + refusedTimesheet;
	}
}
