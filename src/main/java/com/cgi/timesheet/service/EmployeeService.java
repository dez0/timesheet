package com.cgi.timesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.timesheet.domain.Employee;
import com.cgi.timesheet.repository.EmployeeRepository;
import com.cgi.timesheet.util.PasswordUtil;

@Service
public class EmployeeService extends AbstractBaseEntityService<Employee, Integer> {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee findByEmail(String email) {
    	return employeeRepository.findByEmail(email);
    }
    
    public Employee save(Employee employee) {
    	employee.setPassword(PasswordUtil.encode(employee.getPassword()));
    	return super.save(employee);
    }
}
