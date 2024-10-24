package Project2.Hibernate.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import Project2.Hibernate.entities.Department;
import Project2.Hibernate.entities.Employee;
import Project2.Hibernate.repositories.DepartmentRepo;
import Project2.Hibernate.repositories.EmployeeRepo;

@Service
public class EmployeeService {

	private final EmployeeRepo emprepo;
	private final DepartmentRepo deptrepo;

	public EmployeeService(EmployeeRepo emprepo, DepartmentRepo deptrepo) {
		this.emprepo = emprepo;
		this.deptrepo = deptrepo;
	}

	public Employee createEmployee(Employee emp) {
		return emprepo.save(emp);
	}

	public Optional<Employee> getEmployee(Long Id) {
		return emprepo.findById(Id);
	}

	public Optional<Department> getDepartment(Long id) {
		return deptrepo.findById(id);
	}

	public Department createDepartment(Department dept) {
		return deptrepo.save(dept);
	}

}
