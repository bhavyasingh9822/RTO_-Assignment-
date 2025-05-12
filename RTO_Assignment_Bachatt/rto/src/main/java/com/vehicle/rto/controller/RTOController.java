package com.vehicle.rto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.rto.entity.RTO;
import com.vehicle.rto.service.RTOService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RTOController {

	@Autowired
	private RTOService vehicleService;

	@PostMapping("/add/vehicle")
	public ResponseEntity<RTO> addVehicle(@Valid @RequestBody RTO vehicle) {
		return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.CREATED);
	}

	@GetMapping("/vehicles")
	public List<RTO> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

	@GetMapping("/vehicle/{id}")
	public RTO getVehicleById(@PathVariable Long id) {
		return vehicleService.getVehicleById(id);
	}


	@PutMapping("/vehicle/{id}")
	public ResponseEntity<RTO> updateVehicle(@PathVariable Long id, @RequestBody RTO vehicle) {
		RTO updated = vehicleService.updateVehicle(id, vehicle);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
		vehicleService.deleteVehicle(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/vehicles/search")
	public List<RTO> searchVehicles(@RequestParam(required = false) String fuel,
			@RequestParam(required = false) String city, @RequestParam(required = false) String state) {

		if (fuel != null) {
			return vehicleService.searchByFuel(fuel);
		}
		if (city != null) {
			return vehicleService.searchByCity(city);
		}
		if (state != null) {
			return vehicleService.searchByState(state);
		}
		return List.of();
	}
}
