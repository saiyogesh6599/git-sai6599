package Project1.UberX.dto;

import lombok.Data;

@Data
public class SignUPDTO {

	private String email;
	private String password;
	private String name;
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
	public String getName() {
		return name;
	}
	public SignUPDTO(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}
	public SignUPDTO() {
	}
	public void setName(String name) {
		this.name = name;
	}
}
