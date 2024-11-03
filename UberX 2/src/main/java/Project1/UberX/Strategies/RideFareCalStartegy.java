package Project1.UberX.Strategies;

import Project1.UberX.entity.RideRequest;

public interface RideFareCalStartegy {
	
	double RIDE_FARE_MULTIPLIER=10;
	
	double calaculateFare(RideRequest rideRequest);

}
