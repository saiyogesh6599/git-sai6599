package com.springboot.mvc.demo.springboot.dao.impl.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mvc.demo.springboot.dao.impl.dto.EmployeeDTO;
import com.springboot.mvc.demo.springboot.dao.impl.services.EmployeeService;

@RestController
@RequestMapping(path = "/employees")
public class Employee {

	private final EmployeeService EmpService;
//    private static final Logger logger = LogManager.getLogger(Employee.class);

	public Employee(EmployeeService empService) {
		super();
		EmpService = empService;
	}

	@GetMapping("/{employeeId}")
	public Optional<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long Id) {
		return EmpService.getEmployeeById(Id);
	}

	@GetMapping
	public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
			@RequestParam(required = false) String sortBy) {
		return EmpService.getAllEmployees();
	}

	@PostMapping
	public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmpSerive) {
		System.out.println(inputEmpSerive);
//		logger.info(null);

		return EmpService.createNewEmployee(inputEmpSerive);
	}
	
	@PutMapping (path="/{employeeId}")
	public EmployeeDTO updateNewEmployee(@RequestBody EmployeeDTO  employeeDTO, @PathVariable(name="employeeId") Long Id) {
		return EmpService.updateNewEmployee(Id, employeeDTO);	
	}
	@DeleteMapping(path = "/{employeeId}")
	public ResponseEntity<Void> deleteNewEmployee(@PathVariable(name = "employeeId") Long Id) {
		EmpService.deleteNewEmployee(Id);
	    return ResponseEntity.noContent().build();
	}
	@PatchMapping(path="{employeeId}")
	public EmployeeDTO changeNewEmployee(@RequestBody Map<String, Object> updates, 
										@PathVariable(name="employeeId") Long Id) {
		return EmpService.changeNewEmployee(Id, updates);	
	}
	
}









