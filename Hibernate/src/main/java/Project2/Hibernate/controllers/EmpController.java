package Project2.Hibernate.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project2.Hibernate.entities.Employee;
import Project2.Hibernate.service.EmployeeService;

@RequestMapping(path = "/Employee")
@RestController
public class EmpController {

	private final EmployeeService empservice;

	public EmpController(EmployeeService empservice) {
		this.empservice = empservice;
	}

	@GetMapping("/{employeeId}")
	public Optional<Employee> getEmployee(@PathVariable Long employeeId) {
		return empservice.getEmployee(employeeId);

	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee emp) {
		return empservice.createEmployee(emp);

	}
}
