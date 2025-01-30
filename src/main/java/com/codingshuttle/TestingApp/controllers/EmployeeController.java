package com.codingshuttle.TestingApp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		EmployeeDto employeeDto = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employeeDto);
	}

	@PostMapping
	public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto createdEmployeeDto = employeeService.createNewEmployee(employeeDto);
		return new ResponseEntity<>(createdEmployeeDto, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
		EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
