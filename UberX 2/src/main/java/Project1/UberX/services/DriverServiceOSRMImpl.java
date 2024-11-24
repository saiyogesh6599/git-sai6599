package Project1.UberX.services;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	private PaymentService paymentService;
	private DriverService driverService;

	public DriverServiceOSRMImpl(RideRequestService rideRequestService) {
		this.rideRequestService = rideRequestService;
	}

	@Override
	public RideDTO cancelRide(Long rideId) {
		Ride ride = riderService.getRideById(rideId);
		Driver driver = getCurrentDriver();
		if (driver == null) {
			throw new IllegalArgumentException("Driver not authenticated");
		}
		if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
			throw new IllegalArgumentException("ride cannot be cancelled");
		}
		rideService.updateRideStatus(ride, RideStatus.CANCELLED);
		driver.setAvailable(true);
		driverRepo.save(driver);
		setDriverAvailability(ride.getDriver().getId(), true);
		return modelMapper.map(ride, RideDTO.class);
	}

	@Override
	public RideDTO startRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public RideDTO endRide(Long rideId) {
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
		if (!RideStatus.ONGOING.equals(ride.getRideStatus())) {
			throw new IllegalArgumentException("Ride is cannot be ended");
		}
		ride.setEndedAt(LocalDateTime.now());
		Ride savedRide = rideService.updateRideStatus(ride, RideStatus.ENDED);
		driverService.setDriverAvailability(rideId, true);
		paymentService.processPayment(ride);
		return modelMapper.map(savedRide, RideDTO.class);
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
		Driver driver = getCurrentDriver();
		return modelMapper.map(driver, DriverDTO.class);
	}

	@Override
	public Page<RideDTO> getAllMyDriverRide(PageRequest pageRequest) {
		Driver driver = getCurrentDriver();
		Page<Ride> rides = rideService.getAllRidesOfDriver(driver, pageRequest);
		return rides.map(ride -> modelMapper.map(ride, RideDTO.class));
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
		paymentService.createNewPayment(ride);
		// Update ride status and timestamp
		ride.setStartedAt(LocalDateTime.now());
		Ride updatedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);

		// Map updated ride to DTO and return
		return modelMapper.map(updatedRide, RideDTO.class);
	}

	@Override
	public Driver setDriverAvailability(Long driverId, Boolean Available) {
		Driver driver = driverRepo.findById(driverId)
		        .orElseThrow(() -> new RuntimeException("Driver not found"));		
		driver.setAvailable(Available);
		return driverRepo.save(driver);

	}

}
