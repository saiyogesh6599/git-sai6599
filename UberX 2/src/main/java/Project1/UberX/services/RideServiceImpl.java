package Project1.UberX.services;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.entity.Driver;
import Project1.UberX.entity.Ride;
import Project1.UberX.entity.RideRequest;
import Project1.UberX.entity.RideRequestStatus;
import Project1.UberX.entity.RideStatus;
import Project1.UberX.entity.Rider;
import Project1.UberX.repository.RideRepo;

@Service
public class RideServiceImpl implements RideService {

	private RideRepo rideRepo;
	private ModelMapper modelMapper;
	private RideRequestService rideRequestService;

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
	public Ride createNewRide(RideRequest rideRequest, Driver driver) {
		rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);
		Ride ride = modelMapper.map(rideRequest, Ride.class);
		ride.setRideStatus(RideStatus.CONFIRMED);
		ride.setDriver(driver);
		ride.setOtp(generateRandomOTP());
		ride.setId(null);
		rideRequestService.update(rideRequest);
		return rideRepo.save(ride);
	}

	@Override
	public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
		ride.setRideStatus(rideStatus);
		return rideRepo.save(rideStatus);
	}

	@Override
	public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest) {
		return rideRepo.findByRider(rider, pageRequest);
	}

	private String generateRandomOTP() {
		Random random = new Random();
		int otp = random.nextInt();
		return String.format("%04d", otp);
	}

	@Override
	public Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest) {
		return rideRepo.findByDriverId(driver, pageRequest);
	}
}
