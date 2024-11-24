package Project1.UberX.Strategies;

import org.springframework.stereotype.Service;

import Project1.UberX.entity.Driver;
import Project1.UberX.entity.Payment;
import Project1.UberX.entity.PaymentStatus;
import Project1.UberX.entity.Rider;
import Project1.UberX.entity.TransactionType;
import Project1.UberX.services.PaymentService;
import Project1.UberX.services.WalletService;
import jakarta.transaction.Transactional;

@Service
public class WalletPaymentStrategies implements PaymentStrategies {

	private WalletService walletService;
	private PaymentService paymentService;

	@Override
	@Transactional
	public void processPayment(Payment payment) {
		Driver driver = payment.getRide().getDriver();
		Rider rider = payment.getRide().getRider();
		walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount(), payment.getRide(),
				TransactionType.DEBIT);
		double driverCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);
		walletService.addMoneyToWallet(driver.getUser(), driverCut, payment.getRide(), TransactionType.CREDIT);
		paymentService.updatePaymentStatus(payment, PaymentStatus.CONFIRMED);
	}

}
