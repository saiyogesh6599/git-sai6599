package Project1.UberX.Strategies.Impl;

import org.springframework.stereotype.Service;

import Project1.UberX.Strategies.RideFareCalStartegy;
import Project1.UberX.entity.RideRequest;
import Project1.UberX.services.DistanceService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RiderFareDefaultFareCalculationServiceImpl implements RideFareCalStartegy {

	private DistanceService distanceService;

	@Override
	public double calaculateFare(RideRequest rideRequest) {
		double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation(),
				rideRequest.getDropOffLocation());
		return distance*RIDE_FARE_MULTIPLIER;
	}

}
