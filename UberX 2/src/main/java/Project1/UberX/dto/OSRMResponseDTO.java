package Project1.UberX.dto;

import java.util.List;

import lombok.Data;

@Data
public class OSRMResponseDTO {

	    public List<OSRMRoute> getRoutes() {
			return routes;
		}

		public OSRMResponseDTO(List<OSRMRoute> routes) {
			this.routes = routes;
		}

		public void setRoutes(List<OSRMRoute> routes) {
			this.routes = routes;
		}

		private List<OSRMRoute> routes;
	}

