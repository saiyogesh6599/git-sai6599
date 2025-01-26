package com.codingshuttle.TestingApp.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String fullName;

    private Long salary;

    public Employee(Long id, String email, String fullName, Long salary, Department department) {
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.salary = salary;
		this.department = department;
	}

	public Employee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne
    private Department department;
}
