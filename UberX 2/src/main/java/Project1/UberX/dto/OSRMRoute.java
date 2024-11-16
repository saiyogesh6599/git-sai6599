package Project1.UberX.dto;

import lombok.Data;

@Data
public class OSRMRoute {

	    private Double distance;

		public Double getDistance() {
			return distance;
		}

		public void setDistance(Double distance) {
			this.distance = distance;
		}
	}

