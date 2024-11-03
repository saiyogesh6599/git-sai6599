package Project1.UberX.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project1.UberX.dto.RideRequestDTO;
import Project1.UberX.services.RiderService;
import lombok.RequiredArgsConstructor;

@RequestMapping(path = "/rider")
@RestController
@RequiredArgsConstructor
public class RideController {

	private RiderService riderService;

	public RideController(RiderService riderService) {
		this.riderService = riderService;
	}

	@PostMapping("/requestRide")
	public ResponseEntity<RideRequestDTO> requestRide(@RequestBody RideRequestDTO rideRequestDTO) {
		return ResponseEntity.ok(riderService.requestRide(rideRequestDTO));
	}
}
