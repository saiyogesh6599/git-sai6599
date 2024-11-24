package Project1.UberX.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverDTO {

	private Long id;
	private UserDTO user;
	private Double rating;
	private Boolean available;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DriverDTO(Long id, UserDTO user, Double rating, Boolean available, String vehichles) {
		this.id = id;
		this.user = user;
		this.rating = rating;
		this.available = available;
		this.vehichles = vehichles;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getVehichles() {
		return vehichles;
	}

	public void setVehichles(String vehichles) {
		this.vehichles = vehichles;
	}

	private String vehichles;


	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Double getRating() {
		return rating;
	}

	public DriverDTO(UserDTO user, Double rating) {
		this.user = user;
		this.rating = rating;
	}

	public DriverDTO() {
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
}
