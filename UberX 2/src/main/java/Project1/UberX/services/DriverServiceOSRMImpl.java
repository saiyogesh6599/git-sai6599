package Project1.UberX.services;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import Project1.UberX.dto.DriverDTO;
import Project1.UberX.dto.RideDTO;
import Project1.UberX.dto.RiderDTO;
import Project1.UberX.entity.Driver;
import Project1.UberX.entity.Ride;
import Project1.UberX.entity.RideRequest;
import Project1.UberX.entity.RideRequestStatus;
import Project1.UberX.entity.RideStatus;
import Project1.UberX.repository.DriverRepo;
import jakarta.transaction.Transactional;

@Service
public class DriverServiceOSRMImpl implements DriverService {

	private RideRequestService rideRequestService;
	private DriverRepo driverRepo;
	private RiderService riderService;
	private ModelMapper modelMapper;
	private RideService rideService;

	public DriverServiceOSRMImpl(RideRequestService rideRequestService) {
		this.rideRequestService = rideRequestService;
	}

	@Override
	public RideDTO cancelRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO startRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO endRide(Long rideI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiderDTO rateRider(Long rideId, Double rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public RideDTO acceptRide(Long rideRequestId) {
		RideRequest rideRequest = rideRequestService.findRideRequestById(rideRequestId);
		if (!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)) {
			throw new RuntimeException("RideRequst cannot be accepted");
		}

		Driver currentDriver = getCurrentDriver();
		if (!currentDriver.getAvailable()) {
			throw new RuntimeException("Driver not available");
		}
		currentDriver.setAvailable(false);
		Driver saveDriver = driverRepo.save(currentDriver);

		Ride ride = rideService.createNewRide(rideRequest, saveDriver);

		return modelMapper.map(ride, RideDTO.class);
	}

	@Override
	public Driver getCurrentDriver() {
		return driverRepo.findById(2L).orElseThrow(() -> new RuntimeException("Driver with ID 2L not found"));
	}

	@Override
	public DriverDTO getMyProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RideDTO> getAllMyRide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO startRide(Long rideId, String otp) {
	    // Fetch the ride and validate its existence
	    Ride ride = riderService.getRideById(rideId);
	    if (ride == null) {
	        throw new IllegalArgumentException("Ride not found");
	    }

	    // Fetch the current driver and validate
	    Driver driver = getCurrentDriver();
	    if (driver == null) {
	        throw new IllegalArgumentException("Driver not authenticated");
	    }

	    if (!driver.equals(ride.getDriver())) {
	        throw new IllegalArgumentException("Driver cannot start this ride");
	    }

	    // Validate ride status
	    if (!RideStatus.CONFIRMED.equals(ride.getRideStatus())) {
	        throw new IllegalArgumentException("Ride is not confirmed");
	    }

	    // Validate OTP
	    if (!otp.trim().equals(ride.getOtp().trim())) {
	        throw new IllegalArgumentException("OTP is not valid");
	    }

	    // Update ride status and timestamp
	    ride.setStartedAt(LocalDateTime.now());
	    Ride updatedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);

	    // Map updated ride to DTO and return
	    return modelMapper.map(updatedRide, RideDTO.class);
	}


}
