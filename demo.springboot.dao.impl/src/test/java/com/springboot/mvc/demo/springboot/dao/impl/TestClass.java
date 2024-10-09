package com.springboot.mvc.demo.springboot.dao.impl;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.springboot.mvc.demo.springboot.dao.impl.dto.EmployeeDTO;

	
	public class TestClass {

		@Test
		public void testCreateNewEmployee() throws Exception {
		    EmployeeDTO employeeDTO = new EmployeeDTO();
		    employeeDTO.setId(100L);
		    employeeDTO.setName("Jane Doe");
		    employeeDTO.setEmail("jane.doe@example.com");
		    employeeDTO.setDateOfJoining(LocalDate.now());
		    employeeDTO.setActive(true);
		}
	}


