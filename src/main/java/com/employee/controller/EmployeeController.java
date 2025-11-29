package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public String deleteEmploye(@PathVariable Employee id) {
		employeeService.deleteEmploye(id);

		return "Eployee details Successfully delete";
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> viewEmployee(@PathVariable int id) {
		Optional<?> emp = employeeService.viewEmployee(id);
		return emp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("update/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> viewAllEMployee() {
		return ResponseEntity.ok(employeeService.viewAllEMployee());
	}
}

// http://localhsot:9091/employee/save
// method name
// http://localhost:9091/employee/delete/id
//http://localhost:9091/employee/update/{id}
//http://localhost:9091/employee/getAllEmployee
