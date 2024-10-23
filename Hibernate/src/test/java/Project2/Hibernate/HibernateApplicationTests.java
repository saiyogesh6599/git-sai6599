package Project2.Hibernate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Project2.Hibernate.repositories.EmployeeRepo;

@SpringBootTest
class HibernateApplicationTests {

	@Autowired
	EmployeeRepo productrepo;

	@Test
	void contextLoads() {
	}
}