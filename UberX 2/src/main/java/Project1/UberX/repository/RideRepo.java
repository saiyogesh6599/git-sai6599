package Project1.UberX.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Project1.UberX.entity.Ride;
import Project1.UberX.entity.RideStatus;

public interface RideRepo extends JpaRepository<Ride, Long> {

	Ride save(RideStatus rideStatus);

}
