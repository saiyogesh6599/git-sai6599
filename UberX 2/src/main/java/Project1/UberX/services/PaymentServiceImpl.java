package Project1.UberX.services;

import Project1.UberX.Strategies.PaymentStrategyManager;
import Project1.UberX.entity.Payment;
import Project1.UberX.entity.PaymentStatus;
import Project1.UberX.entity.Ride;
import Project1.UberX.repository.PaymentRepo;

public class PaymentServiceImpl implements PaymentService {

	private PaymentRepo paymentRepo;
	private PaymentStrategyManager paymentStrategyManager;

	@Override
	public void processPayment(Ride ride) {
		Payment payment=paymentRepo.findByRide(ride);
		paymentStrategyManager.paymentStrategy(payment.getPaymentMethod()).processPayment(payment);
	}

	@Override
	public Payment createNewPayment(Ride ride) {
		Payment payment = new Payment();
		payment.setRide(ride);
		payment.setPaymentMethod(ride.getPaymentMethod());
		payment.setAmount(ride.getFare());
		payment.setPaymentStatus(PaymentStatus.PENDING);

		return paymentRepo.save(payment);
	}

	@Override
	public void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus) {
		payment.setPaymentStatus(paymentStatus);
		paymentRepo.save(payment);
	}
	
}
