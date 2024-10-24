package Project2.Hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project2.Hibernate.entities.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
