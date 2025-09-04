package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveEmployee(Employee employee) {

		employeeRepository.save(employee);
	}

	public void deleteEmploye(Employee id) {
		employeeRepository.delete(id);
	}

	public Optional<?> viewEmployee(int id) {
		return employeeRepository.findById(id);

	}

	public Optional<?> updateEmployee(int id, Employee employee) {
		return employeeRepository.findById(id).map(existing -> {
			existing.setEmail(employee.getEmail());
			existing.setName(employee.getName());
			existing.setSalary(employee.getSalary());
			return employeeRepository.save(existing);
		});
	}

	public List<Employee> viewAllEMployee() {
		return employeeRepository.findAll();
	}
}
