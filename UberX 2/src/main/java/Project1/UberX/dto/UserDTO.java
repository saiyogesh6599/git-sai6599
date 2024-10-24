package Project1.UberX.dto;

import java.util.Set;

import javax.management.relation.Role;

import lombok.Data;

@Data
public class UserDTO {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public UserDTO(String name, String email, Set<Role> roles) {
		this.name = name;
		this.email = email;
		this.roles = roles;
	}

	public UserDTO() {
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	private String name, email;
	private Set<Role> roles;
}
