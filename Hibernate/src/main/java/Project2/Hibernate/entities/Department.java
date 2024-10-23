package Project2.Hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Department")
@NoArgsConstructor
@Builder
@Data
@ToString
public class Department {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departmentid_pk")
	private Long departmentId;
	@Column(name = "departmentname")
	private String name;
	@JoinColumn(name = "employeeid_fk")
	@OneToOne
	private Employee manager;

	public Department() {
		this.departmentId = null; // or provide a default value if needed
		this.name = null; // or provide a default value if needed
		this.manager = null; // or provide a default value if needed
	}

	public Long getId() {
		return departmentId;
	}

	public String getName() {
		return name;
	}

	public Employee getEmployee() {
		return manager;
	}

	public Department(Long id, String name, Employee employee) {
		departmentId = id;
		this.name = name;
		this.manager = employee;
	}

	public void setManager(Employee manager) {
		this.manager = manager; // Set the manager
	}

}
