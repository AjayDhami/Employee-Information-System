package com.spring.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee.model.Employee;
import com.spring.employee.service.EmployeeService;

@RestController
public class EmployeeRESTController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") int empId) {
		return employeeService.getEmployeeById(empId);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") int empId, @RequestBody Employee employee) {
		Employee updateEmployee = employeeService.getEmployeeById(empId);
		return employeeService.updateEmployee(updateEmployee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") int empId) {
		Employee deleteEmployee = employeeService.getEmployeeById(empId);
		employeeService.deleteEmployee(deleteEmployee);
	}
}
