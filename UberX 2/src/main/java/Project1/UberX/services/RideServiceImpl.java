package Project1.UberX.services;

import java.sql.Driver;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.entity.Ride;
import Project1.UberX.entity.RideStatus;

@Service
public class RideServiceImpl implements RideService {

	@Override
	public Ride getRideById(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void matchWithDrivers(RideRequestDTO rideRequestDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ride createNewRide(RideRequestDTO rideRequestDTO, Driver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Driver> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
