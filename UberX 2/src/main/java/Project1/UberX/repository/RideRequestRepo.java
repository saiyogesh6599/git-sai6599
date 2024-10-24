package Project1.UberX.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Project1.UberX.entity.RideRequest; // Ensure this imports the correct entity

public interface RideRequestRepo extends JpaRepository<RideRequest, Long> {

}