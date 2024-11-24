package Project1.UberX.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
	
    Page<RideDTO> getAllMyDriverRide(PageRequest pageRequest);
	
	Driver getCurrentDriver();

	RideDTO startRide(Long rideId, String otp);	
	
	Driver setDriverAvailability (Long driverId, Boolean Available);
	
}
