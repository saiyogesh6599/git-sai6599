package Project1.UberX.Strategies;

import Project1.UberX.entity.PaymentMethod;

public class PaymentStrategyManager {

	private WalletPaymentStrategies walletPaymenStrategies;
	private CashPaymentStrategies cashPaymentStrategies;
	
	public PaymentStrategies paymentStrategy(PaymentMethod paymentMethod) {
	    return switch (paymentMethod) {
	        case WALLET -> walletPaymenStrategies;
	        case CASH -> cashPaymentStrategies;
	        default -> throw new RuntimeException("Invalid payment");
	    };
	}
}
