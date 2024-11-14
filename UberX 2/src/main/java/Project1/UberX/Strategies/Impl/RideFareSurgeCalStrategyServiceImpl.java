package Project1.UberX.Strategies.Impl;

import org.springframework.stereotype.Service;

import Project1.UberX.Strategies.RideFareCalStartegy;
import Project1.UberX.entity.RideRequest;
import Project1.UberX.services.DistanceService;

@Service
public class RideFareSurgeCalStrategyServiceImpl implements RideFareCalStartegy{

	private DistanceService distanceService;
	private double SURGE_FACTOR=2;

	@Override
	public double calaculateFare(RideRequest rideRequest) {
		double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation(),
				rideRequest.getDropOffLocation());
		return distance*RIDE_FARE_MULTIPLIER*SURGE_FACTOR;
	}
}
