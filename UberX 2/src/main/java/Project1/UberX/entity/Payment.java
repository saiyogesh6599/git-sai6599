package Project1.UberX.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {

	@jakarta.persistence.Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Enumerated (EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	@OneToOne (fetch = FetchType.LAZY)
	private Ride ride;
	
	private Double amount;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Ride getRide() {
		return ride;
	}

	public Payment() {
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Payment(Long id, PaymentMethod paymentMethod, Ride ride, Double amount, LocalDateTime paymentTime,
			PaymentStatus paymentStatus) {
		Id = id;
		this.paymentMethod = paymentMethod;
		this.ride = ride;
		this.amount = amount;
		this.paymentTime = paymentTime;
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@CreationTimestamp
	private LocalDateTime paymentTime;
	
	@Enumerated (EnumType.STRING)
	private PaymentStatus paymentStatus;
}
