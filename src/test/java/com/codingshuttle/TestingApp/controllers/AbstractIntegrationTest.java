package com.codingshuttle.TestingApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.codingshuttle.TestingApp.TestContainerConfiguration;
import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.entities.Employee;

@AutoConfigureWebTestClient(timeout = "100000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestContainerConfiguration.class)
public class AbstractIntegrationTest {

	@Autowired
	WebTestClient webTestClient;

	Employee testEmployee;
	EmployeeDto testEmployeeDto;

	public AbstractIntegrationTest() {
		// Using setters
		testEmployee = new Employee();
		testEmployee.setId(1L);
		testEmployee.setEmail("sai@gmail.com");
		testEmployee.setFullName("sai");
		testEmployee.setSalary(200L);

		testEmployeeDto = new EmployeeDto();
		testEmployeeDto.setId(1L);
		testEmployeeDto.setEmail("sai1@gmail.com");
		testEmployeeDto.setName("sai");
		testEmployeeDto.setSalary(200L);
	}
}
