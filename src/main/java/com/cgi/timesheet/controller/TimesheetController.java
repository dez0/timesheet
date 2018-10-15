package com.cgi.timesheet.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgi.timesheet.domain.Employee;
import com.cgi.timesheet.domain.Project;
import com.cgi.timesheet.domain.Timesheet;
import com.cgi.timesheet.service.EmployeeService;
import com.cgi.timesheet.service.TimesheetService;
import com.cgi.timesheet.util.DateUtil;
import com.cgi.timesheet.util.TimesheetStatusEnum;

@Controller
@RequestMapping("/timesheets")
public class TimesheetController extends AbstractBaseEntityController<TimesheetService, Timesheet, Integer> {
	
	@Autowired
	private TimesheetService timesheetService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public String list(Model model, @AuthenticationPrincipal User user) {
		Employee currentEmployee = employeeService.findByEmail(user.getUsername());
		model.addAttribute("allTimesheets", timesheetService.findAllByEmployee(currentEmployee));
		model.addAttribute("allManagedEmployeeTimesheets", timesheetService.findAllPendingByManager(currentEmployee));
		model.addAttribute("allProjects", currentEmployee.getProjects());
		return "timesheet_list";
	}

	@ResponseBody
    @PostMapping("/add")
    public Integer save(@RequestParam Date timesheetDate, @RequestParam Project project, @AuthenticationPrincipal User user) {
		Employee currentEmployee = employeeService.findByEmail(user.getUsername());
		Date startDate = DateUtil.getPreviousSundayFromDate(timesheetDate);
		Timesheet timesheet = timesheetService.createDraftTimesheet(currentEmployee, project, startDate);
		timesheet = timesheetService.save(timesheet);
    	return timesheet.getId();
    }
	
	@GetMapping(value = "/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model, @AuthenticationPrincipal User user) {
		Employee currentEmployee = employeeService.findByEmail(user.getUsername());
		
		Timesheet timesheet = timesheetService.findById(id).get();
		model.addAttribute("timesheet", timesheet);
		model.addAttribute("currentEmployeeId", currentEmployee.getId());
		model.addAttribute("readonly", !timesheet.getTimesheetStatus().getName().equals(TimesheetStatusEnum.DRAFT.getNom()) 
										&& !timesheet.getTimesheetStatus().getName().equals(TimesheetStatusEnum.REFUSED.getNom()));
		model.addAttribute("pending", timesheet.getTimesheetStatus().getName().equals(TimesheetStatusEnum.PENDING.getNom()));
		return "timesheet_edit";
	}
	
	@PostMapping(value="/edit", params="action=draft")
	public String saveDraft(@ModelAttribute Timesheet timesheet, Model model) {
		timesheetService.updateTimesheet(timesheet, TimesheetStatusEnum.DRAFT.getNom(), true);
		return "redirect:/timesheets/"+timesheet.getId()+"/edit?draft=true";
	}

	@PostMapping(value="/edit", params="action=submit")
	public String submit(@ModelAttribute Timesheet timesheet, Model model) {
		timesheetService.updateTimesheet(timesheet, TimesheetStatusEnum.PENDING.getNom(), true);
		return "redirect:?submit=true";
	}

	@PostMapping(value="/edit", params="action=approve")
	public String approve(@ModelAttribute Timesheet timesheet, Model model) {
		timesheetService.updateTimesheet(timesheet, TimesheetStatusEnum.APPROVED.getNom(), false);
		return "redirect:?approve=true";
	}

	@PostMapping(value="/edit", params="action=refuse")
	public String refuse(@ModelAttribute Timesheet timesheet, Model model) {
		timesheetService.updateTimesheet(timesheet, TimesheetStatusEnum.REFUSED.getNom(), false);
		return "redirect:?refuse=true";
	}
}
