package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.controller.EmployeeController;
import com.employee.entity.Employee;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		
		System.out.println("Employee Application Started..");

	}
	

}
