package com.spring.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employee.exception.EmployeeNotFoundException;
import com.spring.employee.model.Employee;
import com.spring.employee.repos.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
		if (!optionalEmployee.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found", empId);
		}
		return optionalEmployee.get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}

}
