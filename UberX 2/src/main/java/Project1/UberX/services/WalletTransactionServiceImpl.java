package Project1.UberX.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import Project1.UberX.dto.WalletTransactionDTO;
import Project1.UberX.entity.WalletTransactions;
import Project1.UberX.repository.WalletTransactionRepo;

@Service
public class WalletTransactionServiceImpl implements WalletTransactionService{
	
	private WalletTransactionRepo walletTransactionRepo;
	private ModelMapper modelMapper;

	@Override
	public void createNewWalletTransaction(WalletTransactionDTO walletTransactionDTO) {
		WalletTransactions walletTransaction=modelMapper.map(walletTransactionDTO, WalletTransactions.class);
		walletTransactionRepo.save(walletTransaction);
	}

	
}
