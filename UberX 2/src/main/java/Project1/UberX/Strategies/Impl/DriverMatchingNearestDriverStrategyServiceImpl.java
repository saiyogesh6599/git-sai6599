package Project1.UberX.Strategies.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import Project1.UberX.Strategies.DriverMatchingStrategy;
import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.entity.Driver;

@Service
public class DriverMatchingNearestDriverStrategyServiceImpl implements DriverMatchingStrategy {

	@Override
	public List<Driver> findDriver(RideRequestDTO rideRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
