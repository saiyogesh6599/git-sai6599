package com.springboot.mvc.demo.springboot.dao.impl.dto;

import java.time.LocalDate;

public class EmployeeDTO {

	private Long id;
	private String name;
	private String email;
	private LocalDate dateOfJoining;
	private boolean isActive;

	public EmployeeDTO() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", dateOfJoining=");
		builder.append(dateOfJoining);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append("]");
		return builder.toString();
	}

	public EmployeeDTO(Long id, String name, String email, LocalDate dateOfJoining, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
