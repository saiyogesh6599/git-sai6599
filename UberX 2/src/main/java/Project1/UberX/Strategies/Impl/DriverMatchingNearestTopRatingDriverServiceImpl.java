package Project1.UberX.Strategies.Impl;

import java.util.List;

import Project1.UberX.Strategies.DriverMatchingStrategy;
import Project1.UberX.entity.Driver;
import Project1.UberX.entity.RideRequest;
import Project1.UberX.repository.DriverRepo;

public class DriverMatchingNearestTopRatingDriverServiceImpl implements DriverMatchingStrategy {

	private DriverRepo driverRepo;
	@Override
	public List<Driver> findDriver(RideRequest rideRequest) {
		// TODO Auto-generated method stub
		return driverRepo.findTENTopNearestDriver(rideRequest.getPickUpLocation());
	}

}
