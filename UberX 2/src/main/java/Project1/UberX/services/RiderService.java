package Project1.UberX.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import Project1.UberX.dto.RideDTO;
import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.dto.RiderDTO;
import Project1.UberX.entity.Ride;
import Project1.UberX.entity.Rider;
import Project1.UberX.entity.Users;

public interface RiderService {

	RideRequestDTO requestRide(RideRequestDTO rideRequestDTO);

	RiderDTO rateDriver(Long rideId, Double rating);

	RiderDTO getMyProfile();

	Page<RideDTO> getAllMyRide(PageRequest pageRequest);
	
	Rider createNewRider(Users user);
	
	Optional<Rider> getCurrentRider();
	
	Ride getRideById(Long rideId);
	
	RideDTO cancelRide(Long rideId);

}
