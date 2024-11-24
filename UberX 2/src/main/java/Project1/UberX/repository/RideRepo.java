package Project1.UberX.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import Project1.UberX.entity.Driver;
import Project1.UberX.entity.Ride;
import Project1.UberX.entity.RideStatus;
import Project1.UberX.entity.Rider;

public interface RideRepo extends JpaRepository<Ride, Long> {

	Ride save(RideStatus rideStatus);

	Page<Ride> findByDriverId(Driver driver, PageRequest pageRequest);
	
	Page<Ride> findByRider(Rider rider, PageRequest pageRequest);
	

}
