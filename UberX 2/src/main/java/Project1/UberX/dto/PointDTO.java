package Project1.UberX.dto;

import lombok.Data;

@Data
public class PointDTO {

	private double[] coordinates;

	private String type = "Point";

	public double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}

	public PointDTO(double[] coordinates) {
		this.coordinates = coordinates;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
