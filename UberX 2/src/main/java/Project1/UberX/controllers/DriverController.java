package Project1.UberX.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project1.UberX.dto.RideDTO;
import Project1.UberX.dto.RideStartDTO;
import Project1.UberX.services.DriverService;

@RestController
@RequestMapping (path = "/drivers")
public class DriverController {
	
	private DriverService driverService;

	@PostMapping("/acceptRide/{rideRequestId}")
	public ResponseEntity<RideDTO> acceptRide (@PathVariable Long rideRequestId) {
		return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
	}
	@PostMapping("/startRide/{rideRequestId}")
	public ResponseEntity<RideDTO> startRide (@PathVariable Long rideRequestId,
												@PathVariable RideStartDTO rideStartDTO) {
		return ResponseEntity.ok(driverService.startRide(rideRequestId, rideStartDTO.getOtp()));
	}
	
}
