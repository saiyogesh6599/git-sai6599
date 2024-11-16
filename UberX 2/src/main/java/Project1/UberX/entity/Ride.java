package Project1.UberX.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Ride {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(columnDefinition = "Geometry (Point, 4326)")
	private Point pickUpLocation;

	@Column(columnDefinition = "Geometry (Point, 4326)")
	private Point dropOffLocation;

	@CreationTimestamp
	private LocalDateTime createdTime;

	@ManyToOne(fetch = FetchType.LAZY)
	private Rider rider;

	@ManyToOne(fetch = FetchType.LAZY)
	private Driver driver;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	@Enumerated(EnumType.STRING)
	private RideStatus rideStatus;

	private Double fare;

	private LocalDateTime startedAt;

	private LocalDateTime endedAt;
	
	private String Otp;
	
	public Ride(String otp) {
		Otp = otp;
	}

	public String getOtp() {
		return Otp;
	}
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

	public Point getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(Point pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public Point getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(Point dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public RideStatus getRideStatus() {
		return rideStatus;
	}

	public void setRideStatus(RideStatus rideStatus) {
		this.rideStatus = rideStatus;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public Ride() {
	}

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}

	public Ride(Long id, Point pickUpLocation, Point dropOffLocation, LocalDateTime createdTime, Rider rider,
			Driver driver, PaymentMethod paymentMethod, RideStatus rideStatus, Double fare, LocalDateTime startedAt,
			LocalDateTime endedAt) {
		Id = id;
		this.pickUpLocation = pickUpLocation;
		this.dropOffLocation = dropOffLocation;
		this.createdTime = createdTime;
		this.rider = rider;
		this.driver = driver;
		this.paymentMethod = paymentMethod;
		this.rideStatus = rideStatus;
		this.fare = fare;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
	}
	public  String setOtp(String generateRandomOTP) {
		return generateRandomOTP;
	}

}
