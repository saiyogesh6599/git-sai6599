package Project1.UberX.Strategies;

import java.util.List;

import Project1.UberX.entity.Driver;
import Project1.UberX.entity.RideRequest;

public interface DriverMatchingStrategy {

	List<Driver> findDriver(RideRequest rideRequest);
}
