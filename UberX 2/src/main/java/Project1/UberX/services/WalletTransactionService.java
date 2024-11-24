package Project1.UberX.services;

import org.springframework.stereotype.Service;

import Project1.UberX.dto.WalletTransactionDTO;

@Service
public interface WalletTransactionService {

	void createNewWalletTransaction(WalletTransactionDTO walletTransactionDTO);
	
}
