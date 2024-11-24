package Project1.UberX.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import Project1.UberX.entity.Ride;
import Project1.UberX.entity.TransactionType;
import Project1.UberX.entity.Users;
import Project1.UberX.entity.Wallet;

@Service
public interface WalletService {

	void getMyMoneyFromWallet();

	Optional<Wallet> findWalletById(Long walletId);

	Wallet withDrawAllMyMoneyFromWallet();

	Wallet findByUser(Users user);

	Wallet deductMoneyFromWallet(Users user, Double amount, Ride ride, TransactionType transactionType);

	Wallet createNewWallet(Users user);

	Wallet addMoneyToWallet(Users user, double amount, Ride ride, TransactionType transactionType);

}
