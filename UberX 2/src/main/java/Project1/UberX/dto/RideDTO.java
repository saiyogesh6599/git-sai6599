package Project1.UberX.dto;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;

import Project1.UberX.entity.Driver;
import Project1.UberX.entity.PaymentMethod;
import Project1.UberX.entity.RideStatus;
import Project1.UberX.entity.Rider;

public class RideDTO {

	private Long Id;

	private Point pickUpLocation;

	private Point dropOffLocation;

	private LocalDateTime createdTime;

	private Rider rider;

	private Driver driver;

	private PaymentMethod paymentMethod;
	
	private RideStatus rideStatus;

	private Double fare;

	private LocalDateTime startedAt;

	private LocalDateTime endedAt;
	
	public RideDTO() {
	}

	public RideDTO(Long id, Point pickUpLocation, Point dropOffLocation, LocalDateTime createdTime, Rider rider,
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

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}

}
