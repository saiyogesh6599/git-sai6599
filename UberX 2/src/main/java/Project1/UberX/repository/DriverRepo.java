package Project1.UberX.repository;



import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Project1.UberX.entity.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Long>{

	@Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance " +
            "FROM drivers d " +
            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
            "ORDER BY distance ASC",
    nativeQuery = true)
List<Driver> findNearestAvailableDrivers(@Param("pickupLocation") Point pickupLocation);

	
	@Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance " +
            "FROM drivers d " +
            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
            "ORDER BY d.rating DESC, distance ASC " +
            "LIMIT 10",
    nativeQuery = true)
List<Driver> findTENTopNearestDriver(@Param("pickupLocation") Point pickupLocation); 


}
