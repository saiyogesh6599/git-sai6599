package Project1.UberX.services;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import Project1.UberX.entity.RideRequest;
import Project1.UberX.repository.RideRequestRepo;

@Service
public class RideRequestServiceImpl implements RideRequestService {

	private RideRequestRepo rideRequestRepo;

	 @Override
	    public RideRequest findRideRequestById(Long rideRequestId) {
	        return rideRequestRepo.findById(rideRequestId)
	                .orElseThrow(() -> new RuntimeException("RideRequest not found with id: "+rideRequestId));
	    }

	@Override
	public void update(RideRequest rideRequest) {
		rideRequestRepo.findById(rideRequest.getId()).orElseThrow(
				() -> new NoSuchElementException("RideRequest with ID " + rideRequest.getId() + " not found."));
		rideRequestRepo.save(rideRequest);
	}
}
