package Project1.UberX.dto;

import java.util.List;

import Project1.UberX.entity.WalletTransactions;
import lombok.Data;

@Data
public class WalletDTO {

	private Long Id;
	
	private UserDTO userDTO;
	
	private Double balance;
	
	private List<WalletTransactions> transactions;
	
	
}
