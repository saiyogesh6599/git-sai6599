package Project1.UberX.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
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
	
}
