package Project1.UberX.dto;

import java.time.LocalDateTime;

import Project1.UberX.entity.Driver;
import Project1.UberX.entity.PaymentMethod;
import Project1.UberX.entity.RideStatus;
import Project1.UberX.entity.Rider;
import lombok.Data;

@Data
public class RideRequestDTO {

	private Long Id;

	private PointDTO pickUpLocation;

	private PointDTO dropOffLocation;

	private Driver driver;

	private PaymentMethod paymentMethod;

	private RideStatus rideStatus;

	private Double fare;

	private LocalDateTime startedAt;

	private LocalDateTime endedAt;

	private LocalDateTime createdTime;

	private Rider rider;

	public RideRequestDTO() {
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public PointDTO getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(PointDTO pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public PointDTO getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(PointDTO dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
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

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public RideRequestDTO(Long id, PointDTO pickUpLocation, PointDTO dropOffLocation, Driver driver,
			PaymentMethod paymentMethod, RideStatus rideStatus, Double fare, LocalDateTime startedAt,
			LocalDateTime endedAt, LocalDateTime createdTime, Rider rider) {
		Id = id;
		this.pickUpLocation = pickUpLocation;
		this.dropOffLocation = dropOffLocation;
		this.driver = driver;
		this.paymentMethod = paymentMethod;
		this.rideStatus = rideStatus;
		this.fare = fare;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
		this.createdTime = createdTime;
		this.rider = rider;
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

}
