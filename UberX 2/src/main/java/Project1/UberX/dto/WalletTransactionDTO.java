package Project1.UberX.dto;

import java.time.LocalDateTime;
import java.util.Date;

import Project1.UberX.entity.TransactionMethod;
import Project1.UberX.entity.TransactionType;
import lombok.Data;

@Data
public class WalletTransactionDTO {

	private Long Id;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public WalletTransactionDTO() {
	}

	public WalletTransactionDTO(Long id, Double amount, TransactionType transactionType,
			TransactionMethod transactionMethod, RideDTO ride, String transactionId, WalletDTO walletDTO,
			LocalDateTime localDateTime) {
		Id = id;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionMethod = transactionMethod;
		this.ride = ride;
		this.transactionId = transactionId;
		this.walletDTO = walletDTO;
		this.localDateTime = localDateTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public TransactionMethod getTransactionMethod() {
		return transactionMethod;
	}

	public void setTransactionMethod(TransactionMethod transactionMethod) {
		this.transactionMethod = transactionMethod;
	}

	public RideDTO getRide() {
		return ride;
	}

	public void setRide(RideDTO ride) {
		this.ride = ride;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public WalletDTO getWalletDTO() {
		return walletDTO;
	}

	public void setWalletDTO(WalletDTO walletDTO) {
		this.walletDTO = walletDTO;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	private Double amount;

	private TransactionType transactionType;

	private TransactionMethod transactionMethod;

	private RideDTO ride;

	private String transactionId;

	private WalletDTO walletDTO;

	private LocalDateTime localDateTime;

	public void setTransactionDate(Date date) {
		
	}

}
