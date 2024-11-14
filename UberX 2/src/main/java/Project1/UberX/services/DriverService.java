package Project1.UberX.services;

import java.util.List;

import org.locationtech.jts.geom.Point;

import Project1.UberX.dto.DriverDTO;
import Project1.UberX.dto.RideDTO;
import Project1.UberX.dto.RiderDTO;

public interface DriverService {

	RideDTO cancelRide(Long rideId);
	
	RideDTO startRide(Long rideId);
	
	RideDTO endRide(Long rideI);
	
	RiderDTO rateRider(Long rideId, Double rating);
	
	RideDTO acceptRide(Long rideId);
	
	DriverDTO getMyProfile();
	
	List<RideDTO> getAllMyRide();
	
	double calculateDistance(Point src, Point dest);
	
	
	
}
