package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService = new EmployeeService();
	
	@PostMapping("/save")
	public String saveEmploye(@RequestBody Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		return "Employee details Successfully saved";
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmploye(@PathVariable Employee id)
	{
		employeeService.deleteEmploye(id);
		 
		return "Eployee details Successfully delete";
	}
}

// http://localhsot:9090/employee/save
// method name
// http://localhost:9090/employee/delete/id





