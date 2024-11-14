package Project1.UberX.entity;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "driver_app")
@EntityListeners(AuditingEntityListener.class)
public class Driver {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private Users user;
	private Double rating;
	@Column (name = "available")
	private Boolean available;
	@Column(columnDefinition ="Geometry (Point, 4326)")
	private Point currentlocation;
	
	public Driver(Long id, Users user, Double rating, Boolean available, Point currentlocation,
			LocalDateTime createdDate, LocalDateTime lastModified, String createdBy, String updatedBy) {
		this.id = id;
		this.user = user;
		this.rating = rating;
		this.available = available;
		this.currentlocation = currentlocation;
		this.createdDate = createdDate;
		this.lastModified = lastModified;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	@CreatedDate
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	private LocalDateTime lastModified;
	
	@CreatedBy
	private String createdBy;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Boolean getAvailable() {
		return available;
	}

	public Driver() {
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Point getCurrentlocation() {
		return currentlocation;
	}

	public void setCurrentlocation(Point currentlocation) {
		this.currentlocation = currentlocation;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@LastModifiedBy
	private String updatedBy;

}
