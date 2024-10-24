package Project1.UberX.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class WalletTransactions {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private Double amount;

	private TransactionType transactionType;

	private TransactionMethod transactionMethod;
	
	private String transactionId;
	
	public String getTransactionId() {
		return transactionId;
	}

	public WalletTransactions(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@OneToOne
	private Ride ride;
	
	@CreationTimestamp
	private LocalDateTime timeStamp;
	
	@OneToOne
	@JoinColumn (name = "wallet", nullable = false)
	private Wallet wallet;

	public Long getId() {
		return Id;
	}

	public WalletTransactions(Long id, Double amount, TransactionType transactionType,
			TransactionMethod transactionMethod) {
		Id = id;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionMethod = transactionMethod;
	}

	public WalletTransactions() {
	}

	public void setId(Long id) {
		Id = id;
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
}
