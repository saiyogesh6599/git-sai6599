package Project1.UberX.Strategies.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import Project1.UberX.Strategies.DriverMatchingStrategy;
import Project1.UberX.entity.Driver;
import Project1.UberX.entity.RideRequest;
import Project1.UberX.repository.DriverRepo;

@Service
public class DriverMatchingNearestDriverStrategyServiceImpl implements DriverMatchingStrategy {

	private DriverRepo driverRepo;
	
	@Override
	public List<Driver> findDriver(RideRequest rideRequest) {
		return driverRepo.findTENTopNearestDriver(rideRequest.getPickUpLocation());
	}
}
