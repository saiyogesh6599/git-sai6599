package Project1.UberX.services;

import java.sql.Driver;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.entity.Ride;
import Project1.UberX.entity.RideStatus;


public interface RideService {

	Ride getRideById(Long rideId);
	
	void matchWithDrivers(RideRequestDTO rideRequestDTO);
	
	Ride createNewRide(RideRequestDTO rideRequestDTO, Driver driver);
	
	Ride updateRideStatus(Long rideId, RideStatus rideStatus);
	
	Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest);
	
	Page<Driver> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
	
	
}
