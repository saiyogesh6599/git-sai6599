package com.springboot.mvc.demo.springboot.dao.impl.entitle;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
//    private Integer age;
    private LocalDate dateOfJoining;
    private boolean isActive;
//    private String role;
//    private Double salary;
    
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeEntity [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
//		builder.append(", age=");
//		builder.append(age);
		builder.append(", dateOfJoining=");
		builder.append(dateOfJoining);
		builder.append(", isActive=");
		builder.append(isActive);
//		builder.append(", role=");
//		builder.append(role);
//		builder.append(", salary=");
//		builder.append(salary);
		builder.append("]");
		return builder.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}
