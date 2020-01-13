package com.spring.employee.service;

import java.util.List;

import com.spring.employee.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(int empId);

	Employee updateEmployee(Employee employee);

	void deleteEmployee(Employee employee);
}
