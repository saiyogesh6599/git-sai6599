package Project1.UberX.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Project1.UberX.dto.WalletTransactionDTO;
import Project1.UberX.entity.Ride;
import Project1.UberX.entity.TransactionMethod;
import Project1.UberX.entity.TransactionType;
import Project1.UberX.entity.Users;
import Project1.UberX.entity.Wallet;
import Project1.UberX.repository.WalletRepo;
import jakarta.transaction.Transactional;
import lombok.Builder;

@Service
@Builder
public class WalletServiceImpl implements WalletService {

	private WalletRepo walletRepo;
	private Users user;
	private WalletTransactionService walletTransactionService;

	@Override
	@Transactional
	public Wallet addMoneyToWallet(Users user, double amount, Ride ride, TransactionType transactionType) {
		Wallet wallet = walletRepo.findByUser(user);
		if (wallet == null) {
			throw new RuntimeException("Wallet not found for user ID: " + user.getId());
		}
		wallet.setBalance(wallet.getBalance() + amount);

		WalletTransactionDTO walletTransactionDTO = new WalletTransactionDTO();
		walletTransactionDTO.setId(user.getId());
		walletTransactionDTO.setAmount(amount);
		walletTransactionDTO.setTransactionType(TransactionType.CREDIT);
		walletTransactionDTO.setTransactionDate(new Date());
		walletTransactionService.createNewWalletTransaction(walletTransactionDTO);
		return walletRepo.save(wallet);
	}

	@Override
	public void getMyMoneyFromWallet() {

	}

	@Override
	public Optional<Wallet> findWalletById(Long walletId) {
		return walletRepo.findById(walletId);
	}

	@Override
	public Wallet withDrawAllMyMoneyFromWallet() {
		Wallet wallet = new Wallet();
		wallet.setUser(user);
		return walletRepo.save(wallet);
	}

	@Override
	public Wallet findByUser(Users user) {
		return walletRepo.findByUser(user);
	}

	@Override
	@Transactional
	public Wallet deductMoneyFromWallet(Users user, Double amount, Ride ride, TransactionType transactionType) {
		Wallet wallet = findByUser(user);
		wallet.setBalance(wallet.getBalance() - amount);
		WalletTransactionDTO walletTransactionDTO = new WalletTransactionDTO();
		walletTransactionDTO.setId(user.getId());
		walletTransactionDTO.setAmount(amount);
		walletTransactionDTO.setTransactionType(TransactionType.DEBIT);
		walletTransactionDTO.setTransactionDate(new Date());
		walletTransactionService.createNewWalletTransaction(walletTransactionDTO);
		return walletRepo.save(wallet);
	}

	@Override
	public Wallet createNewWallet(Users user) {
	    Wallet wallet = new Wallet();
	    wallet.setUser(user);
	    wallet.setBalance(0.0); // Initial balance
	    return walletRepo.save(wallet); // Save the wallet to the database
	}

}
