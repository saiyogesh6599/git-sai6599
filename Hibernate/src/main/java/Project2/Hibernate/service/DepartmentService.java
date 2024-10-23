package Project2.Hibernate.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import Project2.Hibernate.entities.Department;
import Project2.Hibernate.entities.Employee;
import Project2.Hibernate.repositories.DepartmentRepo;
import Project2.Hibernate.repositories.EmployeeRepo;

@Service
public class DepartmentService {
	
	private final DepartmentRepo deprepo;
	private final EmployeeRepo empRepo;
	
	public DepartmentService(DepartmentRepo deprepo, EmployeeRepo empRepo) {
		this.deprepo = deprepo;
		this.empRepo = empRepo;
	}

	public Department createNewDepartment(Department dept) {
		return deprepo.save(dept);
	}
	public Optional<Department> getNewDepartment(Long Id) {
		return deprepo.findById(Id);
	}

	public Department assignManagerToDepartment(Long departmentId, Long employeeId) {
	    // Retrieve the department and employee
	    Optional<Department> departmentEntity = deprepo.findById(departmentId);
	    Optional<Employee> employeeEntity = empRepo.findById(employeeId);

	    // Check if both the department and employee are present
	    if (departmentEntity.isPresent() && employeeEntity.isPresent()) {
	        Department department = departmentEntity.get();
	        Employee employee = employeeEntity.get();

	        // Set the employee as the manager
	        department.setManager(employee);

	        // Save and return the updated department
	        return deprepo.save(department);
	    }

	    // Return null if either the department or employee is not found
	    return null;
	}}
