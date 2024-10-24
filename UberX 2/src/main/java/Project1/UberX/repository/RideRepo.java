package Project1.UberX.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Project1.UberX.entity.Ride;

public interface RideRepo extends JpaRepository<Ride, Long> {

}
