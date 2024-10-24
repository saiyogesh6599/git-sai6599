package Project2.Hibernate.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project2.Hibernate.entities.Department;
import Project2.Hibernate.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DeptController {

	private final DepartmentService deptservice;

	public DeptController(DepartmentService deptservice) {
		this.deptservice = deptservice;
	}

	@GetMapping("/{departmentId}")
	public Optional<Department> getDeparment(@PathVariable Long departmentId) {
		return deptservice.getNewDepartment(departmentId);
	}

	@PostMapping
	public Department createDepartment(@RequestBody Department dept) {
		return deptservice.createNewDepartment(dept);

	}

	@PutMapping(path = "/{departmentId}/manager/{employeeId}")
	public Department assignManagerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
		return deptservice.assignManagerToDepartment(departmentId, employeeId);

	}
}
