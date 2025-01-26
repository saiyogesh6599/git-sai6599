package com.codingshuttle.TestingApp.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.entities.Employee;
import com.codingshuttle.TestingApp.repositories.EmployeeRepository;

class EmployeeControllerTestIT extends AbstractIntegrationTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() {
		employeeRepository.deleteAll();
	}

	@Test
	void testGetEmployeeById_success() {
		Employee testEmployee = createTestEmployee();
		Employee savedEmployee = employeeRepository.save(testEmployee);

		webTestClient.get().uri("/employees/{id}", savedEmployee.getId()).exchange().expectStatus().isOk().expectBody()
				.jsonPath("$.id").isEqualTo(savedEmployee.getId()).jsonPath("$.email")
				.isEqualTo(savedEmployee.getEmail());
	}

	@Test
	void testGetEmployeeById_Failure() {
		webTestClient.get().uri("/employees/1").exchange().expectStatus().isNotFound();
	}

	@Test
	void testCreateNewEmployee_whenEmployeeAlreadyExists_thenThrowException() {
		Employee testEmployee = createTestEmployee();
		employeeRepository.save(testEmployee);
		EmployeeDto testEmployeeDto = createTestEmployeeDto();

		webTestClient.post().uri("/employees").bodyValue(testEmployeeDto).exchange().expectStatus().is5xxServerError();
	}

	@Test
	void testCreateNewEmployee_whenEmployeeDoesNotExists_thenCreateEmployee() {
		EmployeeDto testEmployeeDto = createTestEmployeeDto();

		webTestClient.post().uri("/employees").bodyValue(testEmployeeDto).exchange().expectStatus().isCreated()
				.expectBody().jsonPath("$.email").isEqualTo(testEmployeeDto.getEmail()).jsonPath("$.name")
				.isEqualTo(testEmployeeDto.getName());
	}

	@Test
	void testUpdateEmployee_whenEmployeeDoesNotExists_thenThrowException() {
		EmployeeDto testEmployeeDto = createTestEmployeeDto();

		webTestClient.put().uri("/employees/999").bodyValue(testEmployeeDto).exchange().expectStatus().isNotFound();
	}

	@Test
	void testUpdateEmployee_whenAttemptingToUpdateTheEmail_thenThrowException() {
		Employee testEmployee = createTestEmployee();
		Employee savedEmployee = employeeRepository.save(testEmployee);
		EmployeeDto testEmployeeDto = createTestEmployeeDto();
		testEmployeeDto.setName("Random Name");
		testEmployeeDto.setEmail("random@gmail.com");

		webTestClient.put().uri("/employees/{id}", savedEmployee.getId()).bodyValue(testEmployeeDto).exchange()
				.expectStatus().is5xxServerError();
	}

	@Test
	void testUpdateEmployee_whenEmployeeIsValid_thenUpdateEmployee() {
		Employee testEmployee = createTestEmployee();
		Employee savedEmployee = employeeRepository.save(testEmployee);
		EmployeeDto testEmployeeDto = createTestEmployeeDto();
		testEmployeeDto.setName("Random Name");
		testEmployeeDto.setSalary(250L);

		webTestClient.put().uri("/employees/{id}", savedEmployee.getId()).bodyValue(testEmployeeDto).exchange()
				.expectStatus().isOk().expectBody(EmployeeDto.class).isEqualTo(testEmployeeDto);
	}

	@Test
	void testDeleteEmployee_whenEmployeeDoesNotExists_thenThrowException() {
		webTestClient.delete().uri("/employees/1").exchange().expectStatus().isNotFound();
	}

	@Test
	void testDeleteEmployee_whenEmployeeExists_thenDeleteEmployee() {
		Employee testEmployee = createTestEmployee();
		Employee savedEmployee = employeeRepository.save(testEmployee);

		webTestClient.delete().uri("/employees/{id}", savedEmployee.getId()).exchange().expectStatus().isNoContent()
				.expectBody(Void.class);

		webTestClient.delete().uri("/employees/{id}", savedEmployee.getId()).exchange().expectStatus().isNotFound();
	}

	// Helper Methods to Create Test Data

	private Employee createTestEmployee() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setEmail("sai@gmail.com");
		employee.setFullName("sai");
		employee.setSalary(200L);
		return employee;
	}

	private EmployeeDto createTestEmployeeDto() {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(1L);
		employeeDto.setEmail("sai@gmail.com");
		employeeDto.setName("sai");
		employeeDto.setSalary(200L);
		return employeeDto;
	}
}
