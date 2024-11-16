package Project1.UberX.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import Project1.UberX.repository.RideRequestRepo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.ToString;

@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString
public class RideRequest {

	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(columnDefinition = "Geometry (Point, 4326)")
	private Point pickUpLocation;

	@Column(columnDefinition = "Geometry (Point, 4326)")
	private Point dropOffLocation;

	@CreationTimestamp
	private LocalDateTime requestTime;

	@ManyToOne(fetch = FetchType.LAZY)
	private Rider rider;

	@Enumerated(EnumType.STRING)
	private RideRequestStatus rideRequestStatus;

	private Double Fare;

	public RideRequest(Double fare) {
		Fare = fare;
	}

	public Double getFare() {
		return Fare;
	}

	public void setFare(Double fare) {
		Fare = fare;
	}

	public RideRequest(Long id, Point pickUpLocation, Point dropOffLocation, LocalDateTime requestTime, Rider rider,
			RideRequestStatus rideRequestStatus, LocalDateTime createdDate, LocalDateTime lastModified) {
		Id = id;
		this.pickUpLocation = pickUpLocation;
		this.dropOffLocation = dropOffLocation;
		this.requestTime = requestTime;
		this.rider = rider;
		this.rideRequestStatus = rideRequestStatus;
		this.createdDate = createdDate;
		this.lastModified = lastModified;
	}

	@CreatedDate
	private LocalDateTime createdDate;

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

	public LocalDateTime getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public RideRequestStatus getRideRequestStatus() {
		return rideRequestStatus;
	}

	public void setRideRequestStatus(RideRequestStatus rideRequestStatus) {
		this.rideRequestStatus = rideRequestStatus;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	@LastModifiedDate
	private LocalDateTime lastModified;

}
