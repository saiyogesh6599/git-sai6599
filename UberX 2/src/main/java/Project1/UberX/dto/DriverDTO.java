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

	private UserDTO user;
	private Double rating;

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
