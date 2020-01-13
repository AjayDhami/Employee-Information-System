package com.spring.employee.exception;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String message, int empId) {
		super(message + " of id: " + empId);
	}
}
