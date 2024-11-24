package Project1.UberX.Strategies;

import org.springframework.stereotype.Service;

import Project1.UberX.entity.Driver;
import Project1.UberX.entity.Payment;
import Project1.UberX.entity.TransactionType;
import Project1.UberX.entity.Wallet;
import Project1.UberX.services.WalletService;

@Service
public class CODPaymentStrategy implements PaymentStrategies {

	private WalletService walletService;

	@Override
	public void processPayment(Payment payment) {
		Driver driver = payment.getRide().getDriver();
		Wallet driverWallet = walletService.findByUser(driver.getUser());
		double platFormCommission = payment.getAmount() * PLATFORM_COMMISSION;
		walletService.deductMoneyFromWallet(driver.getUser(), PLATFORM_COMMISSION, payment.getRide(),
				TransactionType.DEBIT);

	}

}
