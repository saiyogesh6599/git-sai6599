package Project1.UberX.services;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import Project1.UberX.dto.DriverDTO;
import Project1.UberX.dto.RideDTO;
import Project1.UberX.dto.RiderDTO;
import lombok.Data;

@Service
public class DriverServiceOSRMImpl implements DriverService {

	private final String OSRM_API_BASE_URL = "http://router.project-osrm.org/route/v1/driving/";

	@Override
	public RideDTO cancelRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO startRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO endRide(Long rideI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiderDTO rateRider(Long rideId, Double rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO acceptRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDTO getMyProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RideDTO> getAllMyRide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateDistance(Point src, Point dest) {

		try {
			String uri = src.getX() + "," + src.getY() + "," + dest.getX() + "," + dest.getY();
			OSRMResponseDTO responseDto = RestClient.builder().baseUrl(OSRM_API_BASE_URL).build().get().uri(uri)
					.retrieve().body(OSRMResponseDTO.class);
			return responseDto.getRoutes().get(0).getDistance() / 1000.0;
		} catch (Exception e) {
			throw new RuntimeException("Error getting the data from OSRM"+e.getMessage());
		}
	}

	@Data
	class OSRMResponseDTO {
		private List<OSRMRoute> routes;

		public List<OSRMRoute> getRoutes() {
			return routes;
		}

		public void setRoutes(List<OSRMRoute> routes) {
			this.routes = routes;
		}
	}

	@Data
	class OSRMRoute {
		private Double distance;

		public Double getDistance() {
			return distance;
		}

		public void setDistance(Double distance) {
			this.distance = distance;
		}
	}
}
