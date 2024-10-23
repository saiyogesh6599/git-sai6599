package Project2.Hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "employeeid_pk")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	@Column(name = "employeename")
	private String name;
	
	@OneToOne (mappedBy = "manager")
	@JoinColumn (name = "departmentid_fk")
	private Department department;

	// No-argument constructor for Hibernate
	public Employee() {
	}

	public Long getId() {
		return employeeId;
	}

	public Employee(Long id, String name) {
		employeeId = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

}