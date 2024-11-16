package Project1.UberX.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import Project1.UberX.Strategies.RideFareCalStartegy;
import Project1.UberX.Strategies.RideStrategyManager;
import Project1.UberX.dto.RideDTO;
import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.dto.RiderDTO;
import Project1.UberX.entity.Ride;
import Project1.UberX.entity.RideRequest;
import Project1.UberX.entity.RideRequestStatus;
import Project1.UberX.entity.Rider;
import Project1.UberX.entity.Users;
import Project1.UberX.repository.RideRequestRepo;
import Project1.UberX.repository.RiderRepo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RiderServiceImpl implements RiderService {

	private ModelMapper modelMapper;

	private RideFareCalStartegy rideFareCalStartegy;

	private RideRequestRepo rideRequestRepo;

	private RideStrategyManager rideStartegyManager;

	private Rider rider;

	private RiderRepo riderRepo;

	private static final Logger log = LoggerFactory.getLogger(RiderServiceImpl.class);

	public RiderServiceImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
		RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
		rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
		double fare = rideFareCalStartegy.calaculateFare(rideRequest);
		rideRequest.setFare(fare);
		RideRequest saveRideRequest = rideRequestRepo.save(rideRequest);
		List<Project1.UberX.entity.Driver> driver = rideStartegyManager.driverMatchingStartegy(rider.getRating())
				.findDriver(saveRideRequest);
		return modelMapper.map(saveRideRequest, RideRequestDTO.class);
	}

	@Override
	public RiderDTO rateDriver(Long rideId, Double rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiderDTO getMyProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RideDTO> getAllMyRide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rider createNewRider(Users users) {
		Rider rider = new Rider();
		rider.setUser(users);
		rider.setRating(0.0);
		return riderRepo.save(rider);
	}

	@Override
	public Optional<Rider> getCurrentRider() {
		// TODO implement Spring security support
		return riderRepo.findById(1L);
	}

	@Override
	public Ride getRideById(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

}
