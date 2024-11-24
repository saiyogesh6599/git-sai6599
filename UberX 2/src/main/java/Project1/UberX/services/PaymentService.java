package Project1.UberX.services;

import org.springframework.stereotype.Service;

import Project1.UberX.entity.Payment;
import Project1.UberX.entity.PaymentStatus;
import Project1.UberX.entity.Ride;

@Service
public interface PaymentService {


	Payment createNewPayment(Ride ride);

	void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);

	void processPayment(Ride ride);
}
