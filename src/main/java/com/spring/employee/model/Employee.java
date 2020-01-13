package com.spring.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private int id;

	@Column(name = "EMP_NAME")
	private String name;

	@Column(name = "EMP_EMAIL")
	private String email;

	@Column(name = "EMP_ADDRESS")
	private String address;

	@Column(name = "EMP_SALARY")
	private int salary;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String email, String address, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", salary="
				+ salary + "]";
	}

}
