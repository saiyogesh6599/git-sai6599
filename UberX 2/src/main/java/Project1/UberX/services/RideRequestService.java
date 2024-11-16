package Project1.UberX.services;

import org.springframework.stereotype.Service;

import Project1.UberX.entity.RideRequest;

@Service
public interface RideRequestService {

	RideRequest findRideRequestById(Long rideRequestId);

	void update(RideRequest rideRequest);
}
