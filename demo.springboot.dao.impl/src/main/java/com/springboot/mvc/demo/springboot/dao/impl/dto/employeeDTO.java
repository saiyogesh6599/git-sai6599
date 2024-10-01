package com.springboot.mvc.demo.springboot.dao.impl.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;


public class employeeDTO {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private LocalDate dateOfJoining;
	
	private boolean isActive;
	
	public employeeDTO() {
		
	}
	
//	@Override
//	public String toString() {
//		return "employeeDTO [id=" + id + ", name=" + name + ", email=" + email + ", dateOfJoining=" + dateOfJoining
//				+ ", isActive=" + isActive + "]";
//	}

	public employeeDTO(Long id, String name, String email, LocalDate dateOfJoining, boolean isActive) {
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
