package Project1.UberX.services;

import java.util.List;

import Project1.UberX.dto.RideDTO;
import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.dto.RiderDTO;
import Project1.UberX.entity.Rider;
import Project1.UberX.entity.Users;

public interface RiderService {

	RideRequestDTO requestRide(RideRequestDTO rideRequestDTO);

	RiderDTO rateDriver(Long rideId, Double rating);

	RiderDTO getMyProfile();

	List<RideDTO> getAllMyRide();
	
	 Rider createNewRider(Users user);
	
	
}
