package Project1.UberX.services;

import java.util.List;

import Project1.UberX.dto.DriverDTO;
import Project1.UberX.dto.RideDTO;
import Project1.UberX.dto.RiderDTO;
import Project1.UberX.entity.Driver;

public interface DriverService {

	RideDTO cancelRide(Long rideId);
	
	RideDTO startRide(Long rideId);
	
	RideDTO endRide(Long rideI);
	
	RiderDTO rateRider(Long rideId, Double rating);
	
	RideDTO acceptRide(Long rideRequestId);
	
	DriverDTO getMyProfile();
	
	List<RideDTO> getAllMyRide();
	
	Driver getCurrentDriver();

	RideDTO startRide(Long rideId, String otp);	
	
}
