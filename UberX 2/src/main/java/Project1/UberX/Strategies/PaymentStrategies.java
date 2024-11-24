package Project1.UberX.Strategies;

import Project1.UberX.entity.Payment;

public interface PaymentStrategies {

	static final Double PLATFORM_COMMISSION=0.3;
	void processPayment(Payment payment);
	
}
