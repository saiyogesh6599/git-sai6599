package com.codingshuttle.TestingApp.dto;

import java.util.Objects;

import lombok.Data;

@Data
public class EmployeeDto {
	private Long id;
	private String email;
	private String name;
	private Long salary;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof EmployeeDto that))
			return false;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getEmail(), that.getEmail())
				&& Objects.equals(getName(), that.getName()) && Objects.equals(getSalary(), that.getSalary());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeDto() {
	}

	public EmployeeDto(Long id, String email, String name, Long salary) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getEmail(), getName(), getSalary());
	}
}
