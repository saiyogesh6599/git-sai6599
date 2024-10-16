package Project1.UberX.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table (name ="app_user")
@NoArgsConstructor
public class Users {
	
	@jakarta.persistence.Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	@Column (unique = true)
	private String email;
	private String password;
	@ElementCollection(fetch = FetchType.LAZY)
	@Enumerated(EnumType.STRING)
	private Set<Roles> roles;
	
	public Users(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.username = name;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
