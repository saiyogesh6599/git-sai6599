package Project1.UberX.dto;

import lombok.Data;

@Data
public class RiderDTO {

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

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public RiderDTO(UserDTO user, Double rating) {
		this.user = user;
		this.rating = rating;
	}

	public RiderDTO() {
	}
}
