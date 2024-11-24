package Project1.UberX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project1.UberX.entity.Payment;
import Project1.UberX.entity.Ride;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long>{

	Payment findByRide(Ride ride);

}
