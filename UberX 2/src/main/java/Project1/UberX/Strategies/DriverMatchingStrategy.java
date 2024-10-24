package Project1.UberX.Strategies;

import java.util.List;

import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.entity.Driver;


public interface DriverMatchingStrategy {

	 List<Driver> findDriver(RideRequestDTO rideRequestDTO);
}
