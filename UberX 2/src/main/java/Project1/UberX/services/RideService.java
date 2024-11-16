package Project1.UberX.services;

import org.springframework.data.domain.PageRequest;

import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.entity.Driver;
import Project1.UberX.entity.Ride;
import Project1.UberX.entity.RideRequest;
import Project1.UberX.entity.RideStatus;

public interface RideService {

	Ride getRideById(Long rideId);

	void matchWithDrivers(RideRequestDTO rideRequestDTO);

	Ride updateRideStatus(Ride ride, RideStatus rideStatus);

	Ride getAllRidesOfRider(Long riderId, PageRequest pageRequest);

	Driver getAllRidesOfDriver(Long driverId, PageRequest pageRequest);

	Ride createNewRide(RideRequest rideRequest, Driver driver);

}
