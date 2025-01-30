package com.codingshuttle.TestingApp.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.codingshuttle.TestingApp.TestContainerConfiguration;
import com.codingshuttle.TestingApp.entities.Employee;

@Import(TestContainerConfiguration.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	private Employee employee;

	@BeforeEach
	void setUp() {
		// Initialize Employee object using setters
		employee = new Employee();
		employee.setId(1L);
		employee.setFullName("Anuj");
		employee.setEmail("anuj@gmail.com");
		employee.setSalary(100L);
	}

	@Test
	void testFindByEmail_whenEmailIsPresent_thenReturnEmployee() {
		// Arrange (Given)
		employeeRepository.save(employee);

		// Act (When)
		List<Employee> employeeList = employeeRepository.findByEmail(employee.getEmail());

		// Assert (Then)
		assertThat(employeeList).isNotNull();
		assertThat(employeeList).isNotEmpty();
		assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());
	}

	@Test
	void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList() {
		// Given
		String email = "notPresent.123@gmail.com";

		// When
		List<Employee> employeeList = employeeRepository.findByEmail(email);

		// Then
		assertThat(employeeList).isNotNull();
		assertThat(employeeList).isEmpty();
	}
}
