package Project1.UberX.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Wallet {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	private Double balance;

	@OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
	private List<WalletTransactions> walletTransactions;

	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime lastModified;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Wallet() {
	}

	public Double getBalance() {
		return balance;
	}

	public Wallet(Long id, Users user, Double balance, List<WalletTransactions> walletTransactions) {
		Id = id;
		this.user = user;
		this.balance = balance;
		this.walletTransactions = walletTransactions;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<WalletTransactions> getWalletTransactions() {
		return walletTransactions;
	}

	public void setWalletTransactions(List<WalletTransactions> walletTransactions) {
		this.walletTransactions = walletTransactions;
	}

}
