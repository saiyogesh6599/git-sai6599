package Project1.UberX.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.entity.Driver;
import Project1.UberX.entity.Ride;
import Project1.UberX.entity.RideRequest;
import Project1.UberX.entity.RideStatus;
import Project1.UberX.entity.Rider;

public interface RideService {

	Ride getRideById(Long rideId);

	void matchWithDrivers(RideRequestDTO rideRequestDTO);

	Ride updateRideStatus(Ride ride, RideStatus rideStatus);

	Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

	public Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);

	Ride createNewRide(RideRequest rideRequest, Driver driver);

}
