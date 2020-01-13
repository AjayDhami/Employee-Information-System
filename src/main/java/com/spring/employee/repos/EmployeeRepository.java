package com.spring.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
